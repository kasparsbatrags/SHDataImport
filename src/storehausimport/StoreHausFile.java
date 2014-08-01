/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storehausimport;

import entity.Gramata;
import entity.Klienti;
import entity.Sadale;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
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
public class StoreHausFile {

    private final DocumentBuilderFactory dbFactory;
    private final File fXmlFile;
    private final Document doc;
    private Gramata thisDoc = null;
    Long docIdents = null;
    public EntityManager companyEntityManager;
    private EntityTransaction thisTransaction = null;
    private Klienti selectedCompanyData = null;
    private boolean existRecordInSadale;
    private Klienti thisClientInfo;
    private Long docMident;
    private Long docSident;
    private final String docNumberAfix = "_SH";
    private String docMcode;
    private String docScode;
    private int docSbident;
    private int docMbident;

    public Klienti getSelectedCompanyData() {
        return selectedCompanyData;
    }

    public void setSelectedCompanyData(Klienti selectedCompanyData) {
        this.selectedCompanyData = selectedCompanyData;
    }

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

    public String getXmlFileInfo() throws Exception {
        String message = "";
        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        if (nDocumentsList.getLength() == 0) {
            throw new Exception("Trūkst tags: 'DmCtrlDoc'");
        }
        for (int temp = 0; temp < nDocumentsList.getLength(); temp++) {
            Node nDocumentNode = nDocumentsList.item(temp);
            if (nDocumentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element documentElement = (Element) nDocumentNode;
                message = message + "StoreHaus sistēmas dokuments ar id" + documentElement.getAttribute("DocId") + System.lineSeparator();
                message = message + documentElement.getAttribute("Caption") + System.lineSeparator();
                message = message + "Dokuments sagatavots: " + documentElement.getAttribute("PrintDate") + System.lineSeparator();
            }
            NodeList nReportParametersList = doc.getElementsByTagName("Report_Row"); //list of parameter section in file
            if (nReportParametersList.getLength() == 0) {
                throw new Exception("Trūkst tags: 'Report_Row'");
            }
            message = message + "Kopējais grāmatojumu skaits:" + nReportParametersList.getLength() + System.lineSeparator();
        }
        return message;
    }

    private Long checkDocumentExist(Date documentDate, String documentNumber) throws Exception {
        if (documentNumber.isEmpty()) {
            throw new Exception("checkIsDocumentInserted netiek padots parametrs documentNumber\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }
        if (documentDate == null) {
            throw new Exception("checkIsDocumentInserted netiek padots parametrs documentDate\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }

        if (companyEntityManager == null) {
            throw new Exception("Funkcijā checkIsDocumentInserted trūkst objekts 'companyEntityManager'.\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
        List<Gramata> existDocumentList = null;
        try {
            existDocumentList = companyEntityManager
                    .createQuery("select g from Gramata g where g.num= :num_ and g.datums= :datums_")
                    .setParameter("num_", documentNumber + docNumberAfix)
                    .setParameter("datums_", documentDate)
                    .getResultList();
        } catch (Exception e) {
            throw new Exception(e);
        }
        if (existDocumentList.size() != 0) {
            if (existDocumentList.size() == 1) {
                thisDoc = (Gramata) existDocumentList.get(0);
                return thisDoc.getIdent();
            }
            if (existDocumentList.size() > 1) {
                throw new Exception("Dokuments ar numuru: " + documentNumber + " un datumu: " + documentDate.toString()
                        + " sistēmā ir vairākos eksemplāros - netiks eksportēts!");
            }
        }
        return null;
    }

    private Klienti getClientInfo(String clientName, String docSenderCode) throws Exception {

        entity.Klienti clientInfo = null;
        entity.KlBanka clientBankInfo = null;
        List clientsList = null;
        List clientsBankList = null;

        if (clientName.isEmpty()) {
            throw new Exception("Neizdevās iegūt informāciju par klientu - trūkst parametrs 'clientName'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }
        if (companyEntityManager != null) {
            try {
                if (docSenderCode.isEmpty()) {
                    clientsList = companyEntityManager.createNamedQuery("Klienti.findByKlients")
                            .setParameter("klients", clientName)
                            .getResultList();
                } else {
                    clientsList = companyEntityManager.createNamedQuery("Klienti.findByKods")
                            .setParameter("kods", docSenderCode)
                            .getResultList();
                }
                if (!clientsList.isEmpty()) {
                    clientInfo = (Klienti) clientsList.get(0);
                    clientsBankList = companyEntityManager
                            .createQuery("select min(k.nr) from KlBanka k where k.ident=:ident")
                            .setParameter("ident", clientInfo.getIdent())
                            .getResultList();

                    if (!clientsBankList.isEmpty() && clientsBankList.get(0) != null) {
                        clientInfo.setBankNr((int) clientsBankList.get(0));
                    } else {
                        clientInfo.setBankNr(0);
                    }
                } else {
                    return null;
                }
            } catch (PersistenceException ex) {
                throw new Exception(ex.getMessage());
            }
        }
        return clientInfo;
    }

    private boolean checkExistRecordInSadale(Long docIdent,
            String accountDebet,
            String accountCredit,
            Date docDate,
            BigDecimal docSum) throws Exception {

        if (docIdent == null) {
            throw new Exception("Neizdevās pārbaudīt kontējumu - trūkst parametrs 'docIdent'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }
        if (accountDebet.isEmpty()) {
            throw new Exception("Neizdevās pārbaudīt kontējumu - trūkst parametrs 'accountDebet'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }
        if (accountCredit == null) {
            throw new Exception("Neizdevās pārbaudīt kontējumu - trūkst parametrs 'accountCredit'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }

        if (docDate == null) {
            throw new Exception("Neizdevās pārbaudīt kontējumu - trūkst parametrs 'docDate'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }

        if (docSum == null) {
            throw new Exception("Neizdevās pārbaudīt kontējumu - trūkst parametrs 'docSum'\n"
                    + "Restartējiet aplikāciju un meģiniet vēlreiz vai sazinieties ar izstrādātāju");
        }

        if (companyEntityManager == null) {
            throw new Exception("Funkcijā checkSadale trūkst objekts 'companyEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz, vai saznienieties ar izstrādātāju");
        }
        List<Sadale> existSadaleList = null;
        try {
            existSadaleList = companyEntityManager
                    .createQuery("select s from Sadale s where s.ident=:ident_ "
                            + "and s.noK=:no_k_ "
                            + "and s.uzK=:uz_k_ "
                            + "and s.datums=:datums_ "
                            + "and s.summa=:summa_")
                    .setParameter("ident_", docIdent)
                    .setParameter("no_k_", accountCredit)
                    .setParameter("uz_k_", accountDebet)
                    .setParameter("datums_", docDate)
                    .setParameter("summa_", docSum)
                    .getResultList();

        } catch (Exception e) {
            throw new Exception(e);
        }
        return (!existSadaleList.isEmpty());
    }

    private void insertDocument(String docCurrency,
            Date docDate,
            String docNumber,
            String docDebetAccont,
            String docCreditAccont,
            BigDecimal docSum,
            String docReceiverName,
            String docSenderName,
            String docDirection,
            String docSenderCode,
            Date docPayDate
    ) throws Exception {

        if (companyEntityManager == null) {
            throw new Exception("Funkcijā insertDokument trūkst objekts 'companyEntityManager'. \n "
                    + "Restartējiet aplikāciju un meģiniet vēlreiz");
        }
        try {
            try {
                docIdents = checkDocumentExist(docDate, docNumber);
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
            thisTransaction = companyEntityManager.getTransaction();
            if (docIdents != null && (thisDoc.getADatums().compareTo(new Date()) > 0) || docIdents == null) {
                
                if (docIdents == null) {

                    try {
                        thisClientInfo = getClientInfo(docSenderName, docSenderCode);
                        if (thisClientInfo == null) {
                            if ("IEE".equals(docDirection)) {
                                docMident = null;
                                docMcode = "";
                                docMbident = 0;
                                docSident = selectedCompanyData.getIdent();
                                docScode = selectedCompanyData.getKods();
                                docSbident = selectedCompanyData.getBankNr();
                                docReceiverName = selectedCompanyData.getKlients() + ", " + selectedCompanyData.getTips();
                            }else {
                                docSident = null;
                                docScode = "";
                                docSbident = 0;
                                docMident = selectedCompanyData.getIdent();
                                docMcode = selectedCompanyData.getKods();
                                docMbident = selectedCompanyData.getBankNr();
                                docSenderName = selectedCompanyData.getKlients() + ", " + selectedCompanyData.getTips();
                            }
                                
                                    
                        } else {
                            if ("IEE".equals(docDirection)) {
                                docReceiverName = selectedCompanyData.getKlients() + ", " + selectedCompanyData.getTips();
                                docSident = selectedCompanyData.getIdent();
                                docScode = selectedCompanyData.getKods();
                                docSbident = selectedCompanyData.getBankNr();

                                docSenderName = thisClientInfo.getKlients() + ", " + thisClientInfo.getTips();
                                docMident = thisClientInfo.getIdent();
                                docMcode = thisClientInfo.getKods();
                                docMbident = thisClientInfo.getBankNr();

                            } else {
                                docReceiverName = thisClientInfo.getKlients() + ", " + thisClientInfo.getTips();
                                docSident = thisClientInfo.getIdent();
                                docScode = thisClientInfo.getKods();
                                docSbident = thisClientInfo.getBankNr();

                                docSenderName = selectedCompanyData.getKlients() + ", " + selectedCompanyData.getTips();
                                docMident = selectedCompanyData.getIdent();
                                docMcode = selectedCompanyData.getKods();
                                docMbident = selectedCompanyData.getBankNr();
                            }
                        }

                    } catch (Exception ex) {
                        throw new Exception(ex.getMessage());
                    }
                    thisTransaction.begin();
                    Query q = companyEntityManager.createNativeQuery("select nextval('gramata_ident_seq')");
                    docIdents = (Long) q.getSingleResult();
                    Gramata document = new Gramata();
                    document.setIdent(docIdents);
                    document.setDatums(docDate);
                    document.setDokDat(docDate);
                    document.setSDatums(docDate);
                    document.setNum(docNumber + docNumberAfix);
                    document.setValuta(docCurrency);
                    document.setSumma(docSum);
                    document.setSummaV(docSum);
                    document.setKurss(new BigDecimal("1"));
                    document.setApmDat(docPayDate);
                    document.setADatums(new Date());
                    document.setDTips(docDirection);
                    document.setMaksa(docSenderName);
                    document.setMident(docMident);
                    document.setMbident(docMbident);
                    document.setMkods(docMcode);
                    document.setSanem(docReceiverName);
                    document.setSident(docSident);
                    document.setSbident(docSbident);
                    document.setSkods(docScode);
                    document.setStavoklis((short) 0);
                    document.setOTips("REK");
                    document.setVidTips("1");
                    document.setAlgas("K");
                    document.setDarVeids("A");
                    document.setTimeIns(new Date());
                    document.setIevDat(new Date());
                    document.setIevOp("SU");
                    document.setOp("SU");
                    document.setKontets(Boolean.FALSE);
                    document.setPamatoj("Importēts no StoreHaus " + new SimpleDateFormat("dd.mm.yyyy HH:mm:ss").format(new Date()));
                    companyEntityManager.persist(document);
                    thisTransaction.commit();
                    storehausimport.mainFrame.addToLog("Pievienoja dokumentu Nr. "+docNumber + docNumberAfix);
                    try {
                        existRecordInSadale = checkExistRecordInSadale(docIdents, docDebetAccont, docCreditAccont, docDate, docSum);
                    } catch (Exception ex) {
                        throw new Exception(ex.getMessage());
                    }
                    if (!existRecordInSadale) {
                        thisTransaction.begin();
                        Sadale sadale = new Sadale();
                        sadale.setIdent(docIdents);
                        sadale.setKontets(Boolean.FALSE);
                        sadale.setUzK(docDebetAccont);
                        sadale.setNoK(docCreditAccont);
                        sadale.setSumma(docSum);
                        sadale.setDatums(docDate);
                        sadale.setSummaV(null);
                        companyEntityManager.persist(sadale);
                        thisTransaction.commit();
                        storehausimport.mainFrame.addToLog("Pievienots dokumenta Nr. "+docNumber + docNumberAfix+" kontējumu debets:"+
                            docDebetAccont+ " kredīts:"+docCreditAccont+" summa:"+docSum);

                    }
                }
            } else {
                storehausimport.mainFrame.addToLog("Kontējums dokumentam Nr. "+docNumber + docNumberAfix+" debets:"+
                    docDebetAccont+ " kredīts:"+docCreditAccont+" summa:"+docSum+" jau eksistē sistēmā - netika pievienots");
                try {
                    existRecordInSadale = checkExistRecordInSadale(docIdents, docDebetAccont, docCreditAccont, docDate, docSum);
                } catch (Exception ex) {
                    throw new Exception(ex.getMessage());
                }
                if (!existRecordInSadale) {
                    thisTransaction.begin();
                    Sadale sadale = new Sadale();
                    sadale.setIdent(docIdents);
                    sadale.setKontets(Boolean.FALSE);
                    sadale.setUzK(docDebetAccont);
                    sadale.setNoK(docCreditAccont);
                    sadale.setSumma(docSum);
                    sadale.setDatums(docDate);
                    sadale.setSummaV(null);
                    companyEntityManager.persist(sadale);
                    BigDecimal docNewSum = thisDoc.getSumma().add(docSum);
                    thisDoc.setSumma(docNewSum);
                    thisDoc.setSummaV(docNewSum);
                    thisTransaction.commit();
                    storehausimport.mainFrame.addToLog("Pievienots dokumenta Nr. "+docNumber + docNumberAfix+" ar kontējumu debets:"+
                            docDebetAccont+ " kredīts:"+docCreditAccont+" summa:"+docSum);
                    
                } else {
                    storehausimport.mainFrame.addToLog("Kontējums dokumentam Nr. "+docNumber + docNumberAfix+" debets:"+
                            docDebetAccont+ " kredīts:"+docCreditAccont+" summa:"+docSum+" jau eksistē sistēmā - netika pievienots");
                    
                }
            }
        } catch (Exception ex) {
            if (companyEntityManager.getTransaction().isActive()) {
                companyEntityManager.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Neizdevās pievienot ierakstu.\nKļūda: " + ex.getMessage());
            storehausimport.mainFrame.addToLog("Neizdevās pievienot ierakstu. Kļūda:" + ex.getMessage());

        }
    }

    public void importAllXmlData() throws Exception {

        NodeList nDocumentsList = doc.getElementsByTagName("DmCtrlDoc"); //list of documents in file
        String docCurrency = "";
        Date docDate = null;
        String docNumber = "";
        String docDebetAccont = "";
        String docCreditAccont = "";
        BigDecimal docSum = null;
        String docReceiverName = "";
        String docSenderName = "";
        String docDirection = "";
        String docSenderCode = "";
        Date docPayDate = null;

        if (nDocumentsList.getLength() == 0) {
            throw new Exception("Failā nav neviena dokumenta!");
        }
        for (int temp = 0; temp < nDocumentsList.getLength(); temp++) {
            Node nDocumentNode = nDocumentsList.item(temp);
            if (nDocumentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element documentElement = (Element) nDocumentNode;
            }
            NodeList nReportDocsList = doc.getElementsByTagName("Report_Row"); //list of documents in file
            if (nReportDocsList.getLength() == 0) {
                throw new Exception("Trūkst informācija par dokumentiem - tags: 'Report_Row'");
            }
            for (int tempDocRows = 0; tempDocRows < nReportDocsList.getLength(); tempDocRows++) {
                Node nDocumentRowNode = nReportDocsList.item(tempDocRows);
                if (nDocumentRowNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nDocumentRowNode;
                    String docDateText = eElement.getElementsByTagName("t113.3.7").item(0).getTextContent();
                    if (!docDateText.isEmpty()) {
                        docDate = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(docDateText);
                    }
                    docCurrency = eElement.getElementsByTagName("t100.3.10").item(0).getTextContent();
                    docNumber = eElement.getElementsByTagName("t113.4.7").item(0).getTextContent();
                    docDebetAccont = eElement.getElementsByTagName("t106.3.1").item(0).getTextContent();
                    docCreditAccont = eElement.getElementsByTagName("t106.3.2").item(0).getTextContent();
                    String docSumText = eElement.getElementsByTagName("t0.1.4").item(0).getTextContent();
                    if (!docSumText.isEmpty()) {
                        docSum = new BigDecimal(docSumText.replaceAll(",", ""));
                    }
                    docReceiverName = eElement.getElementsByTagName("t102.4.9").item(0).getTextContent();
                    if (docReceiverName.endsWith(selectedCompanyData.getKlients())) {
                        docDirection = "IEE";
                    } else {
                        docDirection = "IZE";
                    }
                    docSenderName = eElement.getElementsByTagName("t102.4.8").item(0).getTextContent();
                    docSenderCode = eElement.getElementsByTagName("t102.3.8").item(0).getTextContent();

                    String docPayDateText = eElement.getElementsByTagName("t113.16.7").item(0).getTextContent();
                    if (!docPayDateText.isEmpty()) {
                        docPayDate = new SimpleDateFormat("yyyy-mm-dd", Locale.getDefault()).parse(docPayDateText);
                    }
                    try {
                        insertDocument(docCurrency, docDate, docNumber, docDebetAccont, docCreditAccont, docSum,
                                docReceiverName, docSenderName, docDirection, docSenderCode, docPayDate);
                    } catch (Exception ex) {
                        throw new Exception(ex);
                    }
                }
            }
        }
    }
}
