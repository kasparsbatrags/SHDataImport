/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import entity.Gramata;
import entity.Sadale;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
    private Gramata thisDoc=null;
    Long docIdents=null;
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
        if (thisTransaction == null){
             thisTransaction=companyEntityManager.getTransaction();
        }
       
        List<Gramata> existDocumentList=null;
        try {
            thisTransaction.begin();
            Map<String,Object> props = companyEntityManager.getProperties();
            existDocumentList = companyEntityManager
                    .createQuery("select g from Gramata g where g.num= :num_ and g.datums= :datums_")
                    .setParameter("num_",documentNumber)
                    .setParameter("datums_",documentDate)
                    .getResultList();
            
        }catch(Exception e){ 	          
            if(thisTransaction.isActive())
                thisTransaction.rollback();

                 throw new Exception(e); 
         } 
        thisTransaction.commit();
        if(existDocumentList.size()!=0){
            if (existDocumentList.size()==1){
                thisDoc= (Gramata) existDocumentList.get(0);
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
                                String docNumber,
                                String docDebetAccont,
                                String docCreditAccont,
                                BigDecimal docSum) throws Exception{

        if (companyEntityManager.equals(null)){
            throw new Exception("Funkcijā insertDokument trūkst objekts 'companyEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
        try {
            docIdents=checkDocumentExist(docDate, docNumber); 
            thisTransaction=companyEntityManager.getTransaction();
            if (docIdents == null){
                thisTransaction.begin();
                    Query q = companyEntityManager.createNativeQuery("select nextval('gramata_ident_seq')");
                    docIdents=(Long) q.getSingleResult();
                    Gramata document = new Gramata();
                    document.setIdent(docIdents);
                    document.setDatums(docDate);
                    document.setNum(docNumber);
                    document.setValuta(docCurrency);
                    document.setSumma(docSum);
                    companyEntityManager.persist(document);
                    
                    Sadale sadale = new Sadale();
                    sadale.setIdent(docIdents);
                    sadale.setKontets(Boolean.FALSE);
                    sadale.setUzK(docDebetAccont);
                    sadale.setNoK(docCreditAccont);
                    sadale.setSumma(docSum);
                    sadale.setDatums(docDate);
                    companyEntityManager.persist(sadale);                    
                thisTransaction.commit();
            } else {
                thisTransaction.begin();
                    Sadale sadale = new Sadale();
                    sadale.setIdent(docIdents);
                    sadale.setKontets(Boolean.FALSE);
                    sadale.setUzK(docDebetAccont);
                    sadale.setNoK(docCreditAccont);
                    sadale.setSumma(docSum);
                    sadale.setDatums(docDate);
                    companyEntityManager.persist(sadale);
                    BigDecimal docNewSum=thisDoc.getSumma().add(docSum);
                    thisDoc.setSumma(docNewSum);
                thisTransaction.commit();
            }
           
        } catch (Exception  ex)  {
            if(companyEntityManager.getTransaction().isActive())
                companyEntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Neizdevās pievienot ierakstu.\nKļūda: "+ex.getMessage());
        }
    }
    
    public void importAllXmlData() throws Exception{
         
        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        String      docCurrency="";
        Date        docDate=null;
        String      docNumber="";
        String      docDebetAccont="";
        String      docCreditAccont="";
        BigDecimal  docSum=null;
        
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
                System.out.println("\nCurrent Element :" + nDocumentRowNode.getNodeName());
                if (nDocumentRowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nDocumentRowNode;
                    String docDateText=eElement.getElementsByTagName("t113.3.7").item(0).getTextContent();
                    if (!docDateText.isEmpty()){
                        docDate=new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(docDateText);
                    } else {
                        docDate=null; 
                    }
                    docCurrency=eElement.getElementsByTagName("t100.3.10").item(0).getTextContent();
                    docNumber=eElement.getElementsByTagName("t113.4.7").item(0).getTextContent();
                    docDebetAccont=eElement.getElementsByTagName("t106.3.1").item(0).getTextContent();
                    docCreditAccont=eElement.getElementsByTagName("t106.3.2").item(0).getTextContent();
                    String docSumText=eElement.getElementsByTagName("t0.1.4").item(0).getTextContent();
                    if(!docSumText.isEmpty()){
                        docSum= new BigDecimal(docSumText.replaceAll(",", ""));
                    }
                    
                    try {
                        this.insertDocument(docCurrency, docDate, docNumber,docDebetAccont,docCreditAccont,docSum);
                     } catch (Exception  ex)  {
                         throw new Exception(ex);
                     }
                }
            }
         }
     }
}
