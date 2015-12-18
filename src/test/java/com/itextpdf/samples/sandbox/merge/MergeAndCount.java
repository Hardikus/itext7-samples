/**
 * Example written by Bruno Lowagie.
 */
package com.itextpdf.samples.sandbox.merge;

import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfReader;
import com.itextpdf.core.pdf.PdfWriter;
import com.itextpdf.core.testutils.annotations.type.SampleTest;
import com.itextpdf.utils.PdfSplitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.junit.experimental.categories.Category;

@Category(SampleTest.class)
public class MergeAndCount {
    public static final String DESTFOLDER = "./samples/target/test/resources/sandbox/merge/";
    public static final String RESOURCE
            = "./samples/src/test/resources/sandbox/merge/Wrong.pdf";
    public static void main(String[] args) throws IOException {
        new MergeAndCount().manipulatePdf(DESTFOLDER);
    }
    public void manipulatePdf(final String destFolder) throws IOException {
        PdfDocument pdfDoc = new PdfDocument(new PdfReader(new FileInputStream(RESOURCE)));
        List<PdfDocument> splitDocuments = new PdfSplitter(pdfDoc) {
            int partNumber = 1;
            @Override
            protected PdfWriter getNextPdfWriter(PageRange documentPageRange) {
                try {
                    return new PdfWriter(new FileOutputStream(destFolder + "splitDocument1_" + String.valueOf(partNumber++) + ".pdf"));
                } catch (FileNotFoundException e) {
                    throw new RuntimeException();
                }
            }
        }.splitBySize(200000);
        for (PdfDocument doc : splitDocuments)
            doc.close();
        pdfDoc.close();
    }
}