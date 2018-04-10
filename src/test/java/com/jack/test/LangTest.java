package com.jack.test;

import java.io.InputStream;

import org.junit.Test;

public class LangTest extends BaseTest {
	@Test
	public void testc2(){
		
	}
	@Test
	public void testc1(){
		InputStream inputStream=Object.class.getResourceAsStream("/java/lang/Number.class");
		log(inputStream==null);
		InputStream inputStream1=Object.class.getResourceAsStream("Number.class");
		log(inputStream1==null);
		InputStream inputStream2=Object.class.getResourceAsStream("java/lang/Number.class");
		log(inputStream2==null);
		InputStream inputStream3=Object.class.getResourceAsStream("/Number.class");
		log(inputStream3==null);
		InputStream inputStream4=getClass().getClassLoader().getResourceAsStream("com/jack/test/BaseTest.class");
		log(inputStream4==null);
		InputStream inputStream5=getClass().getClassLoader().getResourceAsStream("BaseTest.class");
		log(inputStream5==null);
		InputStream inputStream6=getClass().getClassLoader().getResourceAsStream("/com/jack/test/BaseTest.class");
		log(inputStream6==null);
		InputStream inputStream7=getClass().getClassLoader().getResourceAsStream("/BaseTest.class");
		log(inputStream7==null);
		InputStream inputStream8=getClass().getClassLoader().getResourceAsStream("/temp/streamtest.txt");
		log(inputStream8==null);
		
	}
	@Test
	public void testc(){
		
		log(sun.misc.Launcher.getBootstrapClassPath());
	}
	@Test
	public void testa() {
		log("sfsdfs");
		log("a1".substring(0, 0).equals(""));
		log("a1".substring(1, 1).equals(""));
		log("sss");
		testb();
	}
	@Test
	public void testb() {
//		log(Reflection.getCallerClass());
		Class<?> cls=null;
		try {
			cls = Class.forName("com.jack.test.UtilsTest");
			log(cls.getClassLoader());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log(cls);
	}
}
