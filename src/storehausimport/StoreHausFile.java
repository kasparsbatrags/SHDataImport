/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import java.io.File;
import java.io.IOException;
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

    StoreHausFile(String xmlFileWithFullPath) throws ParserConfigurationException, SAXException, IOException {
        this.fXmlFile = new File(xmlFileWithFullPath);
        this.dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	doc = dBuilder.parse(fXmlFile);
 	doc.getDocumentElement().normalize();  
    }
    
    public String getFileInfo() throws Exception{
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
                
//                for (int tempParams = 0; tempParams < nReportParametersList.getLength(); tempParams++) {
//                    
//                    NodeList nReportParametersRow = doc.getElementsByTagName("Params_Row"); //list of parameter section in file
//                        for (int tempRow = 0; tempRow < nReportParametersRow.getLength(); tempRow++) {
//                            Node nParamsRowNode = nReportParametersRow.item(tempRow);
//                            if (nParamsRowNode.getNodeType() == Node.ELEMENT_NODE) {
//                                Element eElement = (Element) nParamsRowNode;
//                                returnedMessage=returnedMessage + eElement.getElementsByTagName("t0.1.0").item(0).getTextContent();
//                            }
//                        }
//                }
            
            
        }
        return returnedMessage;
    }
   
    
    
}
