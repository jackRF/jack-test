package com.jack.test;

import org.junit.Test;

import sun.reflect.Reflection;

public class LangTest extends BaseTest {
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
		Class<?> cls=null;
		try {
			cls = Class.forName("com.jack.test.UtilsTest");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log(cls);
	}
}
