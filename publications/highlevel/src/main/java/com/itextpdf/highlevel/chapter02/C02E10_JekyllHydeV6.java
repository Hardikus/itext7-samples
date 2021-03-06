/*
 * This example was written by Bruno Lowagie
 * in the context of the book: iText 7 layout objects
 */
package com.itextpdf.highlevel.chapter02;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.property.AreaBreakType;
import com.itextpdf.test.annotations.WrapToTest;
import java.io.File;
import java.io.IOException;

/**
 * @author Bruno Lowagie (iText Software)
 */
@WrapToTest
public class C02E10_JekyllHydeV6 {
    public static final String SRC = "src/main/resources/pdfs/jekyll_hyde.pdf";
    public static final String DEST = "results/chapter02/jekyll_hyde_v6.pdf";
    
    public static void main(String args[]) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new C02E10_JekyllHydeV6().manipulatePdf(SRC, DEST);
    }
    
    public void manipulatePdf(String src, String dest) throws IOException {

        //Initialize PDF reader
        PdfReader reader = new PdfReader(src);

        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdfDoc = new PdfDocument(reader, writer);
        Document document = new Document(pdfDoc);
        document.setTopMargin(10);
        document.add(new Paragraph("This is the first page!"));
        document.add(new AreaBreak(AreaBreakType.LAST_PAGE));
        document.add(new Paragraph("This is the last page!"));
        document.close();

    }

}
