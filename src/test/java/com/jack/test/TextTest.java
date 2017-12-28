package com.jack.test;

import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

public class TextTest  extends BaseTest{
	@Test
	public void testXML() {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		log(factory);

	}
}
