package org.apache.poi.test;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.junit.Test;

public class XWPFDocumentTest {
	@Test
	public void testLoad() throws Exception {
		XWPFDocument doc = new XWPFDocument(POIXMLDocument.openPackage(getClass().getResource("a.docx").getFile()));
		for (XWPFParagraph par : doc.getParagraphs()) {
				System.out.println(par.getParagraphText());
//				for (IBodyElement el : par.getBody().getBodyElements()) {
//					System.out.println(el.getPart().toString());
//				}
		}
	}
}
