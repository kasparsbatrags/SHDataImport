/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import entity.Agenti;
import entity.Gramata;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
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
            returnedMessage=returnedMessage + "Kopējais dokumentu skaits:"+nReportParametersList.getLength()+"\n";
        }
        return returnedMessage;
    }
    public void insertDocument() throws Exception{
        
        if (companyEntityManager.equals(null)){
            throw new Exception("Funkcijā insertDokument trūkst objekts 'companyEntityPUEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
        try {
            Map<String,Object> props = companyEntityManager.getProperties();    
            thisTransaction=companyEntityManager.getTransaction();
            thisTransaction.begin();
                Gramata dokuments = new Gramata();
                dokuments.setAgents("sss");
                companyEntityManager.persist(dokuments);
            thisTransaction.commit();
        } catch (Exception  ex)  {
            companyEntityManager.getTransaction().rollback();
            JOptionPane.showMessageDialog(null,"Neizdevās pievienot ierakstu "+ex.getMessage());
        }
    }
    public void importXmlFile() throws Exception{
         
        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        String currency="";
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
                    currency=eElement.getAttribute("t100.3.1");
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
    
}
