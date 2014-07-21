/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import entity.Gramata;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Kaspars
 */

public class StoreHausFile  {
    private final DocumentBuilderFactory dbFactory;
    private final File fXmlFile;
    private final Document doc;
    public EntityManager companyEntityManager;
    private EntityTransaction thisTransaction=null;
    

    public void setCompanyEntityPUEntityManager(EntityManager companyEntityManager) {
        this.companyEntityManager = companyEntityManager;
    }
    
    StoreHausFile(String xmlFileWithFullPath) throws ParserConfigurationException, SAXException, IOException {
        this.fXmlFile = new File(xmlFileWithFullPath);
        this.dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	doc = dBuilder.parse(fXmlFile);
 	doc.getDocumentElement().normalize();  
    }
    
    public String getXmlFileInfo() throws Exception{
        String returnedMessage="";
        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        if (nDocumentsList.getLength()==0) { 
            throw new Exception("Trūkst tags: 'DmCtrlDoc'");
        }
        for (int temp = 0; temp < nDocumentsList.getLength(); temp++) {
            Node nDocumentNode = nDocumentsList.item(temp);
            if (nDocumentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element documentElement = (Element) nDocumentNode;
                returnedMessage=returnedMessage+"StoreHaus sistēmas dokuments ar id"+documentElement.getAttribute("DocId")+"\n";
                returnedMessage=returnedMessage+documentElement.getAttribute("Caption")+"\n";
                returnedMessage=returnedMessage+"Dokuments sagatavots: "+documentElement.getAttribute("PrintDate")+"\n";
            }
            NodeList nReportParametersList = doc.getElementsByTagName("Report_Row"); //list of parameter section in file
            if (nReportParametersList.getLength()==0) { 
                throw new Exception("Trūkst tags: 'Report_Row'");
            }
            returnedMessage=returnedMessage + "Kopējais grāmatojumu skaits:"+nReportParametersList.getLength()+"\n";
        }
        return returnedMessage;
    }

    private Long checkDocumentExist(Date documentDate, String documentNumber) throws Exception{
        //if Document with number and date exist and it is one return document ident
        //if document not exist - returning null
        if (documentNumber.isEmpty()) 
            throw new Exception("checkIsDocumentInserted netiek padots parametrs documentNumber\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        if (documentDate.equals(null)) 
            throw new Exception("checkIsDocumentInserted netiek padots parametrs documentDate\n"
            + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        
        if (companyEntityManager.equals(null)){
            throw new Exception("Funkcijā checkIsDocumentInserted trūkst objekts 'companyEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
        if (thisTransaction.equals(null)){
             thisTransaction=companyEntityManager.getTransaction();
        }
        thisTransaction.begin();
        
        List existDocumentList = companyEntityManager
                .createQuery("Select g from gramata g where g.num=:num and g.datums=:datums")
                .setParameter("num",documentNumber)
                .setParameter("datums",documentDate)
                .getResultList();
        
            if(existDocumentList.size()!=0){
                if (existDocumentList.size()==1){
                    Gramata thisDoc= (Gramata) existDocumentList.get(0);
                    return thisDoc.getIdent();
                    
                }
                if (existDocumentList.size()>1){
                    throw new Exception("Dokuments ar numuru: "+ documentNumber+ " un datumu: "+documentDate.toString()
                            +" sistēmā ir vairākos eksemplāros - netiks eksportēts!");
                }
            }
        return null;
    }
    
    
    
    
    public void insertDocument( String docCurrency,
                                Date docDate,
                                String docNumber) throws Exception{

        if (companyEntityManager.equals(null)){
            throw new Exception("Funkcijā insertDokument trūkst objekts 'companyEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
//        Map<String,Object> props = companyEntityManager.getProperties(); 
        try {
            thisTransaction=companyEntityManager.getTransaction();
            thisTransaction.begin();
                Query q = companyEntityManager.createNativeQuery("select nextval('gramata_ident_seq')");
                Long idents=(Long) q.getSingleResult();
                Gramata dokuments = new Gramata();
                dokuments.setIdent(idents);
                dokuments.setAgents("sss");
//                Agenti dokuments = new Agenti();            
//                dokuments.setAgents("sss");
                companyEntityManager.persist(dokuments);
            thisTransaction.commit();
        } catch (Exception  ex)  {
            companyEntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Neizdevās pievienot ierakstu "+ex.getMessage());
        }
    }
    
    public void importAllXmlFile() throws Exception{
         
        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        String  docCurrency="";
        Date    docDate=null;
        String  docNumber="";
        if (nDocumentsList.getLength()==0) { 
            throw new Exception("Failā nav neviena dokumenta!");
        }
        for (int temp = 0; temp < nDocumentsList.getLength(); temp++) {
            Node nDocumentNode = nDocumentsList.item(temp);
            if (nDocumentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element documentElement = (Element) nDocumentNode;
            }
            NodeList nReportDocsList = doc.getElementsByTagName("Report_Row"); //list of documents in file
            if (nReportDocsList.getLength()==0) { 
                throw new Exception("Trūkst informācija par dokumentiem - tags: 'Report_Row'");
            }
            for (int tempDocRows = 0; tempDocRows < nReportDocsList.getLength(); tempDocRows++) {
                Node nDocumentRowNode = nReportDocsList.item(tempDocRows);
                if (nDocumentRowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nDocumentRowNode;
                    docDate=new SimpleDateFormat("YYYY, mm, dd", Locale.ENGLISH).parse(eElement.getAttribute("t113.3.7"));
                    docCurrency=eElement.getAttribute("t100.3.1");
                    docNumber=eElement.getAttribute("t113.4.7");
                    
                    try {
                        this.insertDocument(docCurrency, docDate, docNumber);
                     } catch (Exception  ex)  {
                         new Exception(ex.getMessage());
                     }
                }
                
//                NodeList nDocumentRows = doc.getElementsByTagName("Params_Row"); //list of parameter section in file
//                    for (int tempRow = 0; tempRow < nReportParametersRow.getLength(); tempRow++) {
//                        Node nParamsRowNode = nReportParametersRow.item(tempRow);
//                        if (nParamsRowNode.getNodeType() == Node.ELEMENT_NODE) {
//                            Element eElement = (Element) nParamsRowNode;
//                            currency=eElement.getElementsByTagName("t100.3.1");
//                        }
//                    }
            }

         
         
     }
     }

    void insertDocument() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
