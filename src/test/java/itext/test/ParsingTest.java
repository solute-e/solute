package itext.test;

/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */


import java.io.File;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class ParsingTest {
    /** The content stream of a first PDF. */
    public static final String RESULT1
        = "results/part4/chapter14/contentstream1.txt";
    /** The content stream of a second PDF. */
    public static final String RESULT2
        = "results/part4/chapter14/contentstream2.txt";
    
    /**
     * Reads the content stream of the first page of a PDF into a text file.
     * @param src    the path to a PDF file
     * @param result the path to the resulting text file
     * @throws IOException
     */
    public void readContent(String src, String result) throws IOException {
    	PdfReader reader = new PdfReader(src);
    	String str = PdfTextExtractor.getTextFromPage(reader, 1);
    	System.out.println(str);
    	reader.close();
        
//        FileOutputStream out = new FileOutputStream(result);
//        PdfDictionary dictionary = reader.getPageN(1);
//        out.write(dictionary.getAsString(dictionary.).getBytes("UTF-8"));
//        out.flush();
//        out.close();
//        reader.close();
    }
    
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        ParsingTest example = new ParsingTest();
        new File(RESULT1).getParentFile().mkdirs();
        example.readContent(ClassLoader.getSystemResource("a.pdf").getFile(), RESULT1);
//        example.readContent(Hero1.RESULT, RESULT2);
    }
}