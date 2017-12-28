package com.jack.test;


import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

public class ReflectTest extends BaseTest{
	@Test
	public void testName() throws Exception {
		testMethodExist(ReflectTest.class, "log",Object.class);
		testMethodExist(ReflectTest.class, "toString");
		testMethodExist(ReflectTest.class, "getDescription");
		testMethodExist(ReflectTest.class, "testName");
		
	}
	private void testMethodExist(Class<?> cls,String name,Class<?>...parameterTypes){
		try {
			cls.getMethod(name, parameterTypes);
			log(cls+":"+name);
		} catch (NoSuchMethodException | SecurityException e) {
			logError(cls+":not Exist:"+name);
		}
	}
}
