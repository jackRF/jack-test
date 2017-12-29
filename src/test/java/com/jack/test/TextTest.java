package com.jack.test;

import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

public class TextTest  extends BaseTest{
	@Test
	public void testXML() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		log(factory);
		testa();
	}
	private void testa() {
		log(SAXParserFactory.class.getClassLoader());
		log(ClassLoader.class.getClassLoader());
		log(ClassLoader.getSystemClassLoader());
	}
	@Test
	public void testb() {
		log(System.getProperty("java.home"));

	}
}
