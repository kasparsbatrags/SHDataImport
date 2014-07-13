//package storehausimport;
//
//
//import java.awt.EventQueue;
//import java.io.File;
//import java.io.IOException;
//import java.util.logging.FileHandler;
//import java.util.logging.Logger;
//import java.util.logging.SimpleFormatter;
//import javax.swing.JFileChooser;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
/////*
//// * To change this license header, choose License Headers in Project Properties.
//// * To change this template file, choose Tools | Templates
//// * and open the template in the editor.
//// */
////
////package storehausimport;
////
////import entity.Useri;
////import java.awt.Component;
////import java.awt.Dialog;
////import java.awt.EventQueue;
////import java.awt.HeadlessException;
////import java.util.Iterator;
////import java.util.List;
////import javax.persistence.EntityManager;
////import javax.persistence.EntityManagerFactory;
////import javax.persistence.EntityTransaction;
////import javax.persistence.Persistence;
////import javax.persistence.Query;
////import javax.swing.JButton;
////import javax.swing.JDialog;
////import javax.swing.JFileChooser;
////import static javax.swing.JFileChooser.CUSTOM_DIALOG;
////import static javax.swing.JFileChooser.OPEN_DIALOG;
////import javax.swing.JFrame;
////import javax.swing.JOptionPane;
////import static javax.swing.JOptionPane.getRootFrame;
////import javax.swing.JPasswordField;
////import javax.swing.JTextField;
////import javax.swing.filechooser.FileNameExtensionFilter;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static jdk.nashorn.internal.objects.NativeString.substring;
////import static org.eclipse.persistence.expressions.ExpressionOperator.ascii;
////import static sun.util.calendar.CalendarUtils.mod;
////import static sun.util.calendar.CalendarUtils.mod;
////
/////**
//// *
//// * @author Kaspars
//// */
//public class StoreHausImport {
////
////    /**
////     * @param args the command line arguments
////     */
//    
//   
//    
//
//    
//    public static void main(String[] args) throws IOException {
//        
//        Logger ShLogger = Logger.getLogger("MyLog");  
//        FileHandler logFh;  
//        try {  
//
//             // This block configure the logger with handler and formatter  
//             logFh = new FileHandler("MyLogFile.log");  
//             ShLogger.addHandler(logFh);
//             SimpleFormatter formatter = new SimpleFormatter();  
//             logFh.setFormatter(formatter);  
//
//             // the following statement is used to log any messages  
//             ShLogger.info("My first log");  
//
//         } catch (SecurityException e) {  
//             e.printStackTrace();  
//         } catch (IOException e) {  
//             e.printStackTrace();  
//         }  
//        
//        Runnable r = new Runnable()
//                 
//                   {
//                      @Override
//                      public void run()
//                      {
//                         new mainFrame();
//                      }
//                   };
//      EventQueue.invokeLater(r);
////        
////        
////        
//////        JFileChooser fc = new JFileChooser();
//////        FileNameExtensionFilter filter = new FileNameExtensionFilter("xml");
//////        fc.setFileFilter(filter);
//////        fc.setApproveButtonText("Importēt failu");
//////        int returnVal = fc.showOpenDialog(getRootFrame());
//////        if(returnVal == JFileChooser.APPROVE_OPTION) {
//////            System.out.println("You chose to open this file: " +
//////            fc.getSelectedFile().getName());
//////        }
////////////    JFileChooser chooser = new JFileChooser();
////////////    FileNameExtensionFilter filter = new FileNameExtensionFilter("xml - StoreHaus fails", "xml");
////////////    chooser.setFileFilter(filter);
////////////    chooser.setApproveButtonText("Importēt failu");
////////////    chooser.setApproveButtonMnemonic('a');
////////////    chooser.setDialogTitle("Izvēlaties failu, kuru importēsies!");
////////////    chooser.setDialogType(OPEN_DIALOG);
////////////    chooser.setApproveButtonToolTipText("Apstipriniet iezīmētā faila importēšanu grāmatvedības sistēmā!");
////////////    int returnVal = chooser.showOpenDialog(getRootFrame());
////////////    if(returnVal == JFileChooser.APPROVE_OPTION) {
////////////       System.out.println("You chose to open this file: " +
////////////            chooser.getSelectedFile().toString());
////////////    }
////        
////        
////////         String decodePassword = decodePassword("aaa");
////        
////////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("storeHausImportPU");
////////        EntityManager em = emf.createEntityManager();
////////
////////        JTextField username = new JTextField();
////////        JTextField password = new JPasswordField();
////////        Object[] message = {
////////            "Lietotāājs:", username,
////////            "Parole:", password
////////        };
////////        Object[] buttons = { "Pieslēgties", "Aizvērt" };
////////        int option = JOptionPane.showOptionDialog(null, message, "Pieslēgšanās Grāls datu bāzei", 
////////                JOptionPane.OK_CANCEL_OPTION,
////////                JOptionPane.WARNING_MESSAGE,
////////                null,buttons, buttons[0]);
////
//////////        if (option == JOptionPane.OK_OPTION) {
///////            String decodePassword = decodePassword(password.getText());
////            
//////////            if (username.getText().equals("h") && password.getText().equals("h")) {
//////////                System.out.println("Login successful");
//////////            } else {
//////////                System.out.println("login failed");
//////////            }
//////////        } else {
//////////            System.out.println("Login canceled");
//////////        }
//////////        
////        
////////        try{
////////            EntityTransaction entr=em.getTransaction();
////////            entr.begin();
////////            List listResult = em.createNamedQuery("Useri.findByOp")
////////                    .setParameter("op","SU")
////////                    .getResultList();
////////            if(listResult.size()!=0){
////////              Iterator itr = listResult.iterator();
////////              while(itr.hasNext()){
////////                Useri users = (Useri)itr.next();
////////                System.out.print("Vards:"+users.getVards());
////////                System.out.print(" Uzvards:"+ users.getUzvards());
////////                System.out.println();
////////              }
////////            }
////////            else{
////////              System.out.println("There is no any record.");
////////            }
////////            entr.commit();
////////            }
////////         finally{
////////             em.close();
////////         }
//////        
////
////        
////    }
////        
//////////    private static String decodePassword(String clearPassword){
////////// 
//////////        String  passwordSalt = "ERTUIOPASDFGHJKLZCVBNM1234567890";
//////////        int passwordLenght= clearPassword.length();
//////////        int l1 =passwordSalt.length();
//////////        String plus;
//////////    for (int i = 1; i <(passwordLenght*7);i++){
//////////        
//////////        int aaww=mod(i,passwordLenght)+1;
//////////        String aass1=substring(clearPassword, aaww, 1);
//////////        int aass=String.valueOf(aass1).codePointAt(0)*19;
//////////        int aaabb=String.valueOf(substring(clearPassword, mod((i+1), passwordLenght)+1, 1)).codePointAt(0);
//////////        int a222=(aass+aaabb*71);
//////////        int a12345=mod(a222, 255);
//////////        char rep=(char)a12345;
//////////        String replacement=Character.toString(rep);
//////////        String sentence = "Define, Measure, Analyze, Design and Verify";
//////////        sentence.r
//////////       String clearPasswordNew = clearPassword.substring( mod((i+1), passwordLenght)+1, replacement);
//////////                //char character = (char)ascii;
//////////     int nStartReplacement=mod((i+passwordLenght),passwordLenght)+1;
//////////     plus=substring(clearPassword, mod((i+passwordLenght), passwordLenght)+1, 1);
//////////         
//////////     //p = passwordSalt
//////////       // STUFF(clearPassword, nStartReplacement, 1, 
//////////         //   CHR(MOD((ASC(SUBSTR(p, MOD(i, l)+1, 1))*19+plus), 255)));
//////////        
//////////        
//////////    }
//// 
//// 
////// endf
////// s = 0
////// for i = 1 TO l
//////    s = s+ASC(SUBSTR(p, i, 1))*256**(i-1)
////// endf
////// p = ""
////// do WHILE s!=0
//////    s1 = INT(s/l1)
//////    p = p+SUBSTR(aA, s-s1*l1, 1)
//////    s = s1
////// endd
////// retu SUBSTR(p, 1, 8)
//////        
//////        
////        
////////////        
////////////        return clearPassword;
////////////            
////////////    }
////////////
////////////    private static int mod(int x, int y)    {
////////////        int result = x % y;
////////////        return result < 0? result + y : result;
////////////    }
////////////    
////    
////
////     static class GetXmlFile extends JFileChooser {
////         protected JDialog createDialog(Component parent) throws HeadlessException {
////             JDialog dialog = super.createDialog(parent);
////             dialog.setLocation(300, 200);
////             dialog.setResizable(false);
////             return dialog;
////         }
//     }
//
//    static void readXml(String xmlFile) {
//
//    try {
// 
//	File fXmlFile = new File(xmlFile);
//	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	Document doc = (Document) dBuilder.parse(fXmlFile);
// 	doc.getDocumentElement().normalize();
// 
//	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
// 
//	NodeList nList = doc.getElementsByTagName("DmCtrlDoc");
// 
//	System.out.println("----------------------------");
// 
//	for (int temp = 0; temp < nList.getLength(); temp++) {
// 
//		Node nNode = nList.item(temp);
// 
//		System.out.println("\nCurrent Element :" + nNode.getNodeName());
// 
//		if (nNode.getNodeType() == Node.ELEMENT_NODE) {
// 
//			Element eElement = (Element) nNode;
// 
//			System.out.println("Staff id : " + eElement.getAttribute("id"));
//			System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
//			System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
//			System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
//			System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());
// 
//		}
//	}
//    } catch (Exception e) {
//	e.printStackTrace();
//    }
//  }
//
//    
//    
//  
//}
