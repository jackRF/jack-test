package com.jack.test;

import org.junit.Test;

import com.jack.test.util.ZipUtils;
import com.sun.org.apache.xerces.internal.utils.ObjectFactory;

//import com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl;

public class ClassLoadTest extends BaseTest {
	@Test
	public void testa1() {
		 ClassLoader current = ObjectFactory.class.getClassLoader();
		log(current);
		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		log(cl);
		log(ClassLoader.getSystemClassLoader());
//		Thread.currentThread().setContextClassLoader(null);
		log(com.sun.org.apache.xerces.internal.utils.ObjectFactory.findClassLoader());
	}
	@Test
	public void testa() {
//		SAXParserFactoryImpl test=new SAXParserFactoryImpl();
//		test.setName("hjlhjkyuouyi");
//		log(test.getName());
	}
	@Test
	public void testb() {
//		log(SAXParserFactoryImpl.class.getClassLoader());

	}
	@Test
	public void testc1() {
		Thread.currentThread().setContextClassLoader(null);
		ClassLoader cl=Thread.currentThread().getContextClassLoader();
		log(cl);
		ZipUtils utl=new ZipUtils();
		log(utl);
		log(utl.getClass().getClassLoader());
	}
	@Test
	public void testc() {
	   ClassLoader cl=Thread.currentThread().getContextClassLoader();
	   try {
		Class<?> cls=cl.loadClass("com.sun.org.apache.xerces.internal.jaxp.SAXParserFactoryImpl");
		log(cls.getClassLoader());
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
