package storehausimport;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.OPEN_DIALOG;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.ParserConfigurationException;
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
    
    static Logger logger = Logger.getLogger("SHImportLoger");
    static FileHandler fh;  
    JFileChooser chooser = new JFileChooser();
    public String xmlFileWithFullPath;
    public String selectedCompany;

        
    /**
     * Creates new form mainFrame
     */
    public mainFrame() {
        initComponents();
           
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonChooseCompanie = new javax.swing.JToggleButton();
        labelSelectedCompany = new javax.swing.JTextField();
        labelFileRecordsInfo = new javax.swing.JLabel();
        buttonChoseFile = new javax.swing.JButton();
        labelXmlFilePath = new javax.swing.JLabel();
        labelSelectedXmlFile = new javax.swing.JTextField();
        buttonImportData = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        PanelFileRecordsInfo = new javax.swing.JTextPane();
        buttonCloseApp = new javax.swing.JToggleButton();
        labelXmlFilePath1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(779, 472));
        setName("mainFrame"); // NOI18N

        buttonChooseCompanie.setText("Izvēlēties firmu");
        buttonChooseCompanie.setToolTipText("Izvēlēties firmu, kurā importēsiet dokumentus");
        buttonChooseCompanie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChooseCompanieActionPerformed(evt);
            }
        });

        labelSelectedCompany.setEditable(false);
        labelSelectedCompany.setEnabled(false);
        labelSelectedCompany.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                labelSelectedCompanyActionPerformed(evt);
            }
        });

        labelFileRecordsInfo.setText("Informācija par ierakstiem failā:");
        labelFileRecordsInfo.setEnabled(false);

        buttonChoseFile.setText("Izvēlēties failu");
        buttonChoseFile.setToolTipText("Izvēlieties failu, kurā galbājas no StoreHaus eksportētie faili.");
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

        PanelFileRecordsInfo.setEditable(false);
        PanelFileRecordsInfo.setEnabled(false);
        jScrollPane1.setViewportView(PanelFileRecordsInfo);

        buttonCloseApp.setText("Beigt darbu");
        buttonCloseApp.setToolTipText("Begt darbu aizvērt aplikāciju");
        buttonCloseApp.setMaximumSize(new java.awt.Dimension(101, 23));
        buttonCloseApp.setMinimumSize(new java.awt.Dimension(101, 23));
        buttonCloseApp.setPreferredSize(new java.awt.Dimension(101, 23));
        buttonCloseApp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCloseAppActionPerformed(evt);
            }
        });

        labelXmlFilePath1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelXmlFilePath1.setText("Imortēšana notiks:");
        labelXmlFilePath1.setToolTipText("");
        labelXmlFilePath1.setEnabled(false);
        labelXmlFilePath1.setName("xmlfilePathLabel"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonChooseCompanie, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChoseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonImportData, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFileRecordsInfo)
                    .addComponent(labelXmlFilePath, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelXmlFilePath1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSelectedCompany, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                    .addComponent(labelSelectedXmlFile)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(668, Short.MAX_VALUE)
                .addComponent(buttonCloseApp, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonChooseCompanie)
                    .addComponent(labelXmlFilePath1)
                    .addComponent(labelSelectedCompany))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelXmlFilePath)
                    .addComponent(labelSelectedXmlFile)
                    .addComponent(buttonChoseFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelFileRecordsInfo)
                        .addComponent(buttonImportData))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(297, 297, 297)
                .addComponent(buttonCloseApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
           try {
                StoreHausFile sht =new StoreHausFile(xmlFileWithFullPath);
                String fileRecordsInfo="";
                this.PanelFileRecordsInfo.setText(fileRecordsInfo);
                this.buttonImportData.setEnabled(!fileRecordsInfo.isEmpty());
                this.labelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());
                fileRecordsInfo=sht.getFileInfo();
                this.PanelFileRecordsInfo.setText(fileRecordsInfo);
                this.PanelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());
                this.buttonImportData.setEnabled(!fileRecordsInfo.isEmpty());
                this.labelFileRecordsInfo.setEnabled(!fileRecordsInfo.isEmpty());


            } catch (ParserConfigurationException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,ex.getMessage());
                logger.info(ex.getMessage()+" "+labelSelectedXmlFile);
            } catch (SAXException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,"Kļūda faila "+xmlFileWithFullPath+" struktūrā!"+"\n"+ex.getMessage());
                logger.info(ex.getMessage()+" "+labelSelectedXmlFile);
            } catch (IOException ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                JOptionPane.showMessageDialog(null,"Kļūda faila "+xmlFileWithFullPath+" nolasīšanā! "+"\n"+ex.getMessage());
                logger.info(ex.getMessage()+" "+labelSelectedXmlFile);
            } catch (Exception ex) {
                Logger.getLogger(mainFrame.class.getName()).log(Level.FINER, null, ex);
                logger.info(ex.getMessage()+" "+labelSelectedXmlFile);
                JOptionPane.showMessageDialog(null,"Kļūda! Fails "+xmlFileWithFullPath+" neatbilst noteiktai StoreHaus struktūrai! "+"\n"+ex.getMessage());
            }
           

            
        }
    }//GEN-LAST:event_buttonChoseFileActionPerformed

    private void labelSelectedXmlFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelSelectedXmlFileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSelectedXmlFileActionPerformed

    private void buttonCloseAppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseAppActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_buttonCloseAppActionPerformed

    private void labelSelectedCompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_labelSelectedCompanyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_labelSelectedCompanyActionPerformed

    private void buttonChooseCompanieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChooseCompanieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonChooseCompanieActionPerformed

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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
                try {                   
                    fh = new FileHandler("SHImporter.log");  
                     logger.addHandler(fh);
                    SimpleFormatter formatter = new SimpleFormatter();  
                    
                    fh.setFormatter(formatter);  
                    //logger.info("My first log");  
                    
                    new mainFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SecurityException ex) {
                    Logger.getLogger(mainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane PanelFileRecordsInfo;
    private javax.swing.JToggleButton buttonChooseCompanie;
    private javax.swing.JButton buttonChoseFile;
    private javax.swing.JToggleButton buttonCloseApp;
    private javax.swing.JButton buttonImportData;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelFileRecordsInfo;
    private javax.swing.JTextField labelSelectedCompany;
    private javax.swing.JTextField labelSelectedXmlFile;
    private javax.swing.JLabel labelXmlFilePath;
    private javax.swing.JLabel labelXmlFilePath1;
    // End of variables declaration//GEN-END:variables
}
