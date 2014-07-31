/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storehausimport;

import com.itextpdf.text.Document;  
import com.itextpdf.text.Element;  
import com.itextpdf.text.Font;  
import com.itextpdf.text.Paragraph;  
import com.itextpdf.text.pdf.BaseFont;  
import com.itextpdf.text.pdf.PdfWriter;  
import java.io.BufferedReader;  
import java.io.DataInputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.InputStreamReader;

/**
 *
 * @author Kaspars
 */
public class SaveToPdf {
    FileInputStream iStream=null;  
    DataInputStream in=null;  
    InputStreamReader is=null;  
    BufferedReader br=null;  
    
    

    public boolean save(String inputFilePath, String outputFilePath ) throws Exception {
        if (outputFilePath.isEmpty()){
            throw new Exception("Trūkst parametrs outputFilePath");
        }
        if (inputFilePath.isEmpty()){
            throw new Exception("Trūkst parametrs inputFilePath");
        }
        File inputFile=new File(inputFilePath);
        Document pdfDoc = new Document();
        try {  
            PdfWriter writer=PdfWriter.getInstance(pdfDoc,new FileOutputStream(outputFilePath));
            pdfDoc.open();
            pdfDoc.setMarginMirroring(true);  
            pdfDoc.setMargins(36, 72, 108,180);  
            pdfDoc.topMargin();  
            
            
            BaseFont helvetica = BaseFont.createFont("Helvetica", BaseFont.CP1257, BaseFont.NOT_EMBEDDED);
            Font normal_font = new Font(helvetica, 10, Font.NORMAL);
            Font bold_font = new Font();  
            bold_font.setStyle(Font.BOLD);  
            bold_font.setSize(10);  
            pdfDoc.add(new Paragraph("\n"));  
            if(inputFile.exists()) {  
                iStream = new FileInputStream(inputFile);  
                in = new DataInputStream(iStream);  
                is=new InputStreamReader(in);  
                br = new BufferedReader(is);  
                String strLine;  
                while ((strLine = br.readLine()) != null)   {  
                    Paragraph para =new Paragraph(strLine+"\n",normal_font);  
                    para.setAlignment(Element.ALIGN_LEFT);  
                    pdfDoc.add(para);  
                }  
            } else  {  
                pdfDoc.close();   
                throw new Exception("Trūkst parametrs inputFilePath");
            }  
            pdfDoc.close();   
        } catch (Exception ex) {
            throw new Exception(ex);
        }
        return true;
    }
}


