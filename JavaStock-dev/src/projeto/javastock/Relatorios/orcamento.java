package javastock.Relatorios;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by fernando on 6/19/16.
 */
public class orcamento {

    public static void main(String[] args) {

        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream("VendaDAO.getInstancia().getVenda()"));
            doc.open();


            doc.add(new Paragraph(""));
        } catch (DocumentException de) {
            System.err.println(de.getMessage());
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        doc.close();
    }
}

