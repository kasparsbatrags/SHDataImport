package storehausimport;

import com.hexiong.jdbf.DBFReader;
import entity.Klienti;
import java.awt.Component;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.ServiceUI;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.OPEN_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
import static jdk.nashorn.internal.objects.NativeString.substr;
import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;
import org.xml.sax.SAXException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaspars
 */
public class mainFrame extends javax.swing.JFrame {
    public static File inifile = new File("SHDataImport.ini");
    JFileChooser chooser = new JFileChooser();
    public String xmlFileWithFullPath;
    public String selectedCompanyText;
    public entity.Firmas companieForImport=null;
    public static entity.Klienti selectedCompanyData=null;
    public static EntityManager companyEntityManager=null;
    private static String logFileIndex="";
    private static FileReader inputProcessLogFile = null;
    private static BufferedReader logFileBufferReader;
    private Component saveFileFrame;
    private boolean isIniOk;
    public String gralsIniPath="";
    private String gralsPparamFile="";
    public String digitsAfterDeciaml="";

    public Klienti getSelectedCompanyData() {
        return selectedCompanyData;
    }

    public static void setSelectedCompanyData(Klienti selectedCompanyData) {
        mainFrame.selectedCompanyData = selectedCompanyData;
    }


    public EntityManager getCompanyEntityManager() {
        return companyEntityManager;
    }

    public static void setCompanyEntityManager(EntityManager companyEntityManager) {
        mainFrame.companyEntityManager = companyEntityManager;
    }

    public static void addToLog(String message){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ImportLog_"+logFileIndex+".txt", true)))) {
            out.println(message);
            //out.close();
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Kļūda saglabājot žurnālēšanas failu! "+e.getMessage());
        }
        try {
            refreshProcesPanelInfo();
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Kļūda attēlojot procesa gaitu! "+e.getMessage());
        }
    }

    public static void addToErrorLog(String message){
        try(PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ErrorLog.txt", true)))) {
            out.println(""+message);
           
        }catch (IOException e) {
            JOptionPane.showMessageDialog(null,"Kļūda saglabājot failu ! "+e.getMessage());
        }
    }
    
    public static void refreshProcesPanelInfo() throws FileNotFoundException, Exception{
        try {
            inputProcessLogFile = new FileReader("ImportLog_"+logFileIndex+".txt");
        }catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,"Kļūda saglabājot failu ! "+e.getMessage());
            throw new Exception(e);
        }
        try {
            logFileBufferReader = new BufferedReader(inputProcessLogFile);
            PanelProcessInfo.read(logFileBufferReader, logFileBufferReader);
            PanelProcessInfo.setCaretPosition(PanelProcessInfo.getDocument().getLength());
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
             throw new Exception(ex);
        }

        
    }
    
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
        setIcon();
        setTitle("StoreHouse dokumentu imports sistēmā Grāls v.1.1");
        try {
            digitsAfterDeciaml=getPparamValue("KOMA1");
        } catch (Exception ex) {
        }
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtextSelectedCompany = new javax.swing.JTextField();
        labelFileRecordsInfo = new javax.swing.JLabel();
        buttonChoseFile = new javax.swing.JButton();
        labelXmlFilePath = new javax.swing.JLabel();
        labelSelectedXmlFile = new javax.swing.JTextField();
        buttonImportData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelFileRecordsInfo = new javax.swing.JTextPane();
        labelSelectedCompany = new javax.swing.JLabel();
        buttonChooseCompany = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        labelProcesInfo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        PanelProcessInfo = new javax.swing.JTextPane();
        buttonSaveProcessInfo = new javax.swing.JButton();
        buttonPrintProcessInfo = new javax.swing.JButton();
        buttonChoseGralsIni = new javax.swing.JToggleButton();
        buttonChoseGralsStartInFolder = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(779, 472));
        setName("mainFrame"); // NOI18N

        jtextSelectedCompany.setEditable(false);
        jtextSelectedCompany.setEnabled(false);
        jtextSelectedCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextSelectedCompanyActionPerformed(evt);
            }
        });

        labelFileRecordsInfo.setText("Informācija par ierakstiem failā:");
        labelFileRecordsInfo.setEnabled(false);

        buttonChoseFile.setText("Izvēlēties failu");
        buttonChoseFile.setToolTipText("Izvēlieties failu, kurā galbājas no StoreHaus eksportētie faili.");
        buttonChoseFile.setEnabled(false);
        buttonChoseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoseFileActionPerformed(evt);
            }
        });

        labelXmlFilePath.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelXmlFilePath.setText("Izvēlētais fails:");
        labelXmlFilePath.setEnabled(false);
        labelXmlFilePath.setName("xmlfilePathLabel"); // NOI18N

        labelSelectedXmlFile.setEditable(false);
        labelSelectedXmlFile.setEnabled(false);
        labelSelectedXmlFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelSelectedXmlFileActionPerformed(evt);
            }
        });

        buttonImportData.setText("Importēt");
        buttonImportData.setToolTipText("Importēt failu grāmatvedības sistēmā");
        buttonImportData.setEnabled(false);
        buttonImportData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonImportDataActionPerformed(evt);
            }
        });

        PanelFileRecordsInfo.setEditable(false);
        PanelFileRecordsInfo.setEnabled(false);
        jScrollPane1.setViewportView(PanelFileRecordsInfo);

        labelSelectedCompany.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelSelectedCompany.setText("Imortēšana notiks firmā:");
        labelSelectedCompany.setToolTipText("");
        labelSelectedCompany.setEnabled(false);
        labelSelectedCompany.setName("xmlfilePathLabel"); // NOI18N

        buttonChooseCompany.setText("Izvēlēties firmu");
        buttonChooseCompany.setToolTipText("Izvēlētiesfirmu, kurā importēsiet dokumentus");
        buttonChooseCompany.setEnabled(false);
        buttonChooseCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseCompanyActionPerformed(evt);
            }
        });

        jButton1.setText("Beigt darbu");
        jButton1.setToolTipText("Begt darbu aizvērt aplikāciju");
        jButton1.setMaximumSize(new java.awt.Dimension(105, 23));
        jButton1.setMinimumSize(new java.awt.Dimension(105, 23));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        labelProcesInfo.setText("Informācija par procesa gaitu:");
        labelProcesInfo.setEnabled(false);

        PanelProcessInfo.setEditable(false);
        PanelProcessInfo.setEnabled(false);
        jScrollPane2.setViewportView(PanelProcessInfo);

        buttonSaveProcessInfo.setText("Saglabāt pdf");
        buttonSaveProcessInfo.setToolTipText("Saglabāt procesa gaitu pdf failā");
        buttonSaveProcessInfo.setEnabled(false);
        buttonSaveProcessInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveProcessInfoActionPerformed(evt);
            }
        });

        buttonPrintProcessInfo.setVisible(false);
        buttonPrintProcessInfo.setText("Drukāt atskaiti");
        buttonPrintProcessInfo.setToolTipText("Drukāt procesa gaitu");
        buttonPrintProcessInfo.setEnabled(false);
        buttonPrintProcessInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrintProcessInfoActionPerformed(evt);
            }
        });

        buttonChoseGralsIni.setVisible(!inifile.isFile() && checkIsIniOk()<3);
        buttonChoseGralsStartInFolder.setVisible(checkIsIniOk()==2);
        buttonChoseGralsIni.setText("Izvēlieties Grāls ini failu");
        buttonChoseGralsIni.setToolTipText("Norādiet Grals.ini faila atrašanās vietu");
        mainFrame.this.buttonChooseCompany.setEnabled(!buttonChoseGralsIni.isVisible() && !buttonChoseGralsStartInFolder.isVisible());
        buttonChoseGralsIni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoseGralsIniActionPerformed(evt);
            }
        });

        buttonChoseGralsStartInFolder.setText("Izvēlieties Grāls lietotāja paramteru failu");
        buttonChoseGralsStartInFolder.setToolTipText("Norādiet Grāls StartIn mapi un failu pparam.dbf");
        buttonChoseGralsStartInFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChoseGralsStartInFolderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(buttonChoseFile, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(buttonChooseCompany, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelFileRecordsInfo)
                                        .addComponent(labelXmlFilePath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labelSelectedCompany, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(buttonImportData, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelProcesInfo)))
                            .addComponent(buttonSaveProcessInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonPrintProcessInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtextSelectedCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(labelSelectedXmlFile)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonChoseGralsIni)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonChoseGralsStartInFolder)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChoseGralsIni)
                    .addComponent(buttonChoseGralsStartInFolder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelSelectedCompany)
                    .addComponent(jtextSelectedCompany)
                    .addComponent(buttonChooseCompany))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelXmlFilePath)
                    .addComponent(labelSelectedXmlFile)
                    .addComponent(buttonChoseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFileRecordsInfo)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonImportData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonPrintProcessInfo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonSaveProcessInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelProcesInfo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonChoseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoseFileActionPerformed
        // TODO add your handling code here:

        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml - StoreHaus fails", "xml");
        chooser.setFileFilter(filter);
        chooser.setApproveButtonText("Importēt failu");
        chooser.setApproveButtonMnemonic('a');
        chooser.setDialogTitle("Izvēlaties failu, kuru importēsies!");
        chooser.setDialogType(OPEN_DIALOG);
        chooser.setApproveButtonToolTipText("Apstipriniet iezīmētā faila importēšanu grāmatvedības sistēmā!");
        int returnVal = chooser.showOpenDialog(mainFrame.this);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
           xmlFileWithFullPath=chooser.getSelectedFile().toString();
           mainFrame.this.labelSelectedXmlFile.setText(xmlFileWithFullPath);
           this.labelXmlFilePath.setEnabled(!xmlFileWithFullPath.isEmpty());
           this.labelSelectedXmlFile.setEnabled(!xmlFileWithFullPath.isEmpty());
           storehausimport.mainFrame.addToLog("Izvēlēts fails: "+xmlFileWithFullPath+", no kura tiks importēti dokumenti.");
           try {
                StoreHausFile sht =new StoreHausFile(xmlFileWithFullPath);
                String fileRecordsInfo="";
                this.PanelFileRecordsInfo.setText(fileRecordsInfo);
                this.buttonImportData.setEnabled(!fileRecordsInfo.isEmpty());
                this.labelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());
                fileRecordsInfo=sht.getXmlFileInfo();
                this.PanelFileRecordsInfo.setText(fileRecordsInfo);
                this.PanelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());
                this.buttonImportData.setEnabled(!fileRecordsInfo.isEmpty());
                this.labelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());
                storehausimport.mainFrame.addToLog("Informācija par failu: "+fileRecordsInfo);


            } catch (ParserConfigurationException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,ex.getMessage());
            } catch (SAXException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,"Kļūda faila "+xmlFileWithFullPath+" struktūrā!"+"\n"+ex.getMessage());
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,"Kļūda faila "+xmlFileWithFullPath+" nolasīšanā! "+"\n"+ex.getMessage());
            } catch (Exception ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,"Kļūda! Fails "+xmlFileWithFullPath+" neatbilst noteiktai StoreHaus struktūrai! "+"\n"+ex.getMessage());
            }
           

            
        }
    }//GEN-LAST:event_buttonChoseFileActionPerformed

    private void labelSelectedXmlFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelSelectedXmlFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSelectedXmlFileActionPerformed

    private void jtextSelectedCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextSelectedCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtextSelectedCompanyActionPerformed

    private void buttonChooseCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseCompanyActionPerformed
        // TODO add your handling code here:
        CompanieForImport selectedComanieForImport = new CompanieForImport();
        selectedComanieForImport.setcompanieForImport(companieForImport);
        selectedComanieForImport.setJtextSelectedCompany(jtextSelectedCompany);
        selectedComanieForImport.setVisible(true);
        this.labelSelectedCompany.setEnabled(!selectedComanieForImport.equals(null));
        this.jtextSelectedCompany.setEnabled(!selectedComanieForImport.equals(null));
        this.buttonChoseFile.setEnabled(!selectedComanieForImport.equals(null));
        
        
    }//GEN-LAST:event_buttonChooseCompanyActionPerformed

    private void buttonImportDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportDataActionPerformed
        try {
            // TODO add your handling code here:
            checkIsIniOk();
            try {
                digitsAfterDeciaml=getPparamValue("KOMA1");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Kļūda! \nNeizdevās nolasīt no Grals lietotaja iestatijumiem ciparu skaitu aiz komata!\n"+ex.getMessage()+
                        "\nImporetēšana tiks veikta ar precizitāti 2 cipari aiz komata!");                    
            }
            if (digitsAfterDeciaml.isEmpty()){
                digitsAfterDeciaml="2.0";
            }
            digitsAfterDeciaml=digitsAfterDeciaml.replace(",",".");
            this.PanelProcessInfo.setEnabled(true);
            StoreHausFile shf =new StoreHausFile(xmlFileWithFullPath);  
            shf.setCompanyEntityPUEntityManager(companyEntityManager);
            shf.setSelectedCompanyData(selectedCompanyData);
            shf.setDigitsAfterDeciaml(Integer.parseInt((String) substr(digitsAfterDeciaml,0,digitsAfterDeciaml.indexOf("."))));
            
            shf.importAllXmlData();
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Kļūda StoreHausFile! "+ex.getMessage());
        } finally {
            storehausimport.mainFrame.addToLog("Imports pabeigts!");
            JOptionPane.showMessageDialog(null,"Beidzu!");
            this.buttonPrintProcessInfo.setEnabled(PanelProcessInfo.getDocument().getLength()>0);
            this.buttonSaveProcessInfo.setEnabled(PanelProcessInfo.getDocument().getLength()>0);
        }
        
    }//GEN-LAST:event_buttonImportDataActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void buttonSaveProcessInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveProcessInfoActionPerformed
        // TODO add your handling code here:
        String filename = File.separator+"pdf";
        JFileChooser fileChooser = new JFileChooser(new File(filename));
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("PDF Documents", "pdf"));
        fileChooser.setAcceptAllFileFilterUsed(true);
        int result = fileChooser.showSaveDialog(saveFileFrame);
        if (result == JFileChooser.APPROVE_OPTION) {
            if(fileChooser.getSelectedFile().exists()){
                int result_ = JOptionPane.showConfirmDialog(this,"Fails jau eksistē, rakstīt virsū?","Eksistējošs fails",JOptionPane.YES_NO_CANCEL_OPTION);
                switch(result_){
                    case JOptionPane.YES_OPTION:
                        try {
                            SaveToPdf save = new SaveToPdf();
                            if (save.save("ImportLog_"+logFileIndex+".txt", fileChooser.getSelectedFile().toString())){
                                 JOptionPane.showMessageDialog(null,"Fails saglabāts veiksmīgi!");
                            }
                        } catch (Exception ex) {
                            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            JOptionPane.showMessageDialog(null,"Kļūda saglabājot failu! "+fileChooser.getSelectedFile().toString()+
                                    "\n"+ex.getMessage());
                        }
                        return ;
                    case JOptionPane.NO_OPTION:
                        return;
                    case JOptionPane.CLOSED_OPTION:
                        return;
                    case JOptionPane.CANCEL_OPTION:
                        return;
                }
            } else {
                try {
                    SaveToPdf save = new SaveToPdf();
                    if (save.save("ImportLog_"+logFileIndex+".txt", fileChooser.getSelectedFile().toString())){
                        JOptionPane.showMessageDialog(null,"Fails saglabāts veiksmīgi!");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null,"Kļūda saglabājot failu! "+fileChooser.getSelectedFile().toString()+
                        "\n"+ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_buttonSaveProcessInfoActionPerformed

    private void buttonPrintProcessInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrintProcessInfoActionPerformed
        // TODO add your handling code here:
        FileInputStream textStream = null;
        try {
            textStream = new FileInputStream("ImportLog_"+logFileIndex+".txt");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
        Doc mydoc = new SimpleDoc(textStream, flavor, null);
        AttributeSet aset = null;

        PrintService[] services = PrintServiceLookup.lookupPrintServices(
				flavor, aset);
   PrintService defaultService = PrintServiceLookup.lookupDefaultPrintService();

   if(services.length == 0) {
       if(defaultService == null) {
             //no printer found

       } else {
           try {
               //print using default
               DocPrintJob job = defaultService.createPrintJob();
               job.print(mydoc, (PrintRequestAttributeSet) aset);
           } catch (PrintException ex) {
               Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }

       }

    } else {

       //built in UI for printing you may not use this
       PrintService service = ServiceUI.printDialog(null, 200, 200, services, defaultService, flavor, (PrintRequestAttributeSet) aset);


        if (service != null)
        {
           try {
               DocPrintJob job = service.createPrintJob();
               job.print(mydoc, (PrintRequestAttributeSet) aset);
           } catch (PrintException ex) {
               Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
        }

    }
    }//GEN-LAST:event_buttonPrintProcessInfoActionPerformed

    private void buttonChoseGralsIniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoseGralsIniActionPerformed
        // TODO add your handling code here:
                JFileChooser iniChooser = new JFileChooser();
                try {
                    
                    FileNameExtensionFilter iniFilter = new FileNameExtensionFilter("ini - Grāls sistēmas konfigurācijas fails", "ini");
                    iniChooser.setFileFilter(iniFilter);
                    iniChooser.setApproveButtonText("Izvēlēties failu");
                    iniChooser.setApproveButtonMnemonic('a');
                    iniChooser.setDialogTitle("Izvēlaties Grāls konfigurācijas failu - grals.ini!");
                    iniChooser.setDialogType(OPEN_DIALOG);
                    iniChooser.setApproveButtonToolTipText("Apstipriniet!");
                    int iniReturnVal = iniChooser.showOpenDialog(mainFrame.this);
                    if(iniReturnVal == JFileChooser.APPROVE_OPTION) {
                        Boolean iniOk=this.writeIni("GralsIniPath",iniChooser);
                        this.buttonChoseGralsIni.setVisible(!iniOk);
                        this.buttonChoseGralsStartInFolder.setVisible(!this.isIniOk);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Neizdevās izveidot ini failu.\n Kļūda: "+ex.getMessage());
                }
        
    }//GEN-LAST:event_buttonChoseGralsIniActionPerformed

    private void buttonChoseGralsStartInFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChoseGralsStartInFolderActionPerformed
        JFileChooser pparamChooser = new JFileChooser();
        try {
                    
            FileNameExtensionFilter pparamFilter = new FileNameExtensionFilter("pparam.dbf - Grāls lietotāja parametru fails", "dbf");
            pparamChooser.setFileFilter(pparamFilter);
            pparamChooser.setApproveButtonText("Izvēlēties failu");
            pparamChooser.setApproveButtonMnemonic('a');
            pparamChooser.setDialogTitle("Izvēlaties Grāls lietotāja iestatījumu failu - pparam.dbf!");
            pparamChooser.setDialogType(OPEN_DIALOG);
            pparamChooser.setApproveButtonToolTipText("Apstipriniet!");
            int iniReturnVal = pparamChooser.showOpenDialog(mainFrame.this);
            if(iniReturnVal == JFileChooser.APPROVE_OPTION) {
                Boolean iniOk=this.writeIni("GralsStartInFolder",pparamChooser);
                this.buttonChoseGralsStartInFolder.setVisible(!iniOk);
                this.buttonChooseCompany.setEnabled(iniOk);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Neizdevās saglabāt ini failā parametru .\n Kļūda: "+ex.getMessage());
        }
    }//GEN-LAST:event_buttonChoseGralsStartInFolderActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new mainFrame().setVisible(true);
            DateFormat df = new SimpleDateFormat("ddMMyyyy_HHmm");
            Date today = Calendar.getInstance().getTime();
            logFileIndex=df.format(today);
        });
    }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane PanelFileRecordsInfo;
    private static javax.swing.JTextPane PanelProcessInfo;
    private javax.swing.JButton buttonChooseCompany;
    private javax.swing.JButton buttonChoseFile;
    private javax.swing.JToggleButton buttonChoseGralsIni;
    private javax.swing.JButton buttonChoseGralsStartInFolder;
    private javax.swing.JButton buttonImportData;
    private javax.swing.JButton buttonPrintProcessInfo;
    private javax.swing.JButton buttonSaveProcessInfo;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextField jtextSelectedCompany;
    private javax.swing.JLabel labelFileRecordsInfo;
    private javax.swing.JLabel labelProcesInfo;
    private javax.swing.JLabel labelSelectedCompany;
    private javax.swing.JTextField labelSelectedXmlFile;
    private javax.swing.JLabel labelXmlFilePath;
    // End of variables declaration//GEN-END:variables

    private void setIcon() {
        try{
            setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Refresh.png")));        
         } catch (Exception ex) {
            Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);            
         }
             
        
    }
    
    private int checkIsIniOk() {
        if (!inifile.isFile()){
            return 0;
        }
        try {
            Wini ini = new Wini(inifile);
            gralsIniPath=ini.get("main", "GralsIniPath", String.class);
            gralsPparamFile=ini.get("main", "GralsStartInFolder", String.class);
            if (gralsIniPath==null){
                return 1;
            }
            if (gralsPparamFile==null){
                return 2;
            }
        } catch (InvalidFileFormatException e) {
             JOptionPane.showMessageDialog(null, "Nepareizs ini faila formāts.\n Kļūda: "+e.getMessage());
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "Nevaru nolasīt ini failu: "+inifile.toString()+"\n Kļūda: "+e.getMessage());
            
        }
        return 3;
           
    }
    private boolean writeIni(String VariableName, JFileChooser iniChooser) throws IOException{
        try {
            if (!inifile.isFile()){
                PrintWriter writer = new PrintWriter(inifile, "UTF-8");
                writer.close();
            }
            Wini ini = new Wini(inifile);
            ini.put("main", VariableName,iniChooser.getSelectedFile().toString());
            ini.store();
            int iniIsRedy=this.checkIsIniOk();
            if (VariableName=="GralsIniPath" && iniIsRedy==2) {
                return true;
            } else if(VariableName!="GralsIniPath" && iniIsRedy==3) {
                return true;
            }
                
                
            
        } catch (InvalidFileFormatException e) {
             JOptionPane.showMessageDialog(null, "Nepareizs ini faila formāts.\n Kļūda: "+e.getMessage());
             return false;
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Nevaru nolasīt ini failu: "+inifile.toString()+"\n Kļūda: "+e.getMessage());
             return false;
            
        }
        return true;
    }
    public static String readGralsIni(String section,String variable) throws Exception{
        if (!inifile.isFile()){
            throw new Exception("Trūkst ini fails: "+inifile.toString());
        }
        try {
            Wini ini = new Wini(inifile);
            String gralsIniFullPath=ini.get("main", "GralsIniPath", String.class);
            ini = new Wini(new File(gralsIniFullPath));
            String readValue= ini.get(section, variable, String.class);
            if (!readValue.isEmpty()){
                return readValue;
            }
        } catch (InvalidFileFormatException e) {
             JOptionPane.showMessageDialog(null, "Nepareizs ini faila formāts.\n Kļūda: "+e.getMessage());
        } catch (IOException e) {
             JOptionPane.showMessageDialog(null, "Nevaru nolasīt ini failu: "+inifile.toString()+"\n Kļūda: "+e.getMessage());
            
        }
        return "";
    }
    public String getPparamValue(String valuesName) throws Exception{
        DBFReader dbfreader = new DBFReader(gralsPparamFile);
        String result="";
        try {
            while(dbfreader.hasNextRecord())
            {
                Object pparamRecord[]= dbfreader.nextRecord(Charset.forName("GBK"));
                if (pparamRecord[0].toString().equalsIgnoreCase(valuesName)){
                    result= (String) pparamRecord[2].toString();
                    dbfreader.close();
                    return result;
               }
            }
        } catch (Exception ex) {
            dbfreader.close();
            result="";
        }finally{
//            pparam.close();  // don't forget to close it!
        }
        dbfreader.close();
        return result;
    }
}
