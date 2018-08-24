package com.jack.test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class MyTest extends BaseTest {
	static{
		System.out.println("MyTest class init...");
	}
	{
		System.out.println("constructor...");
	}
	@Test
	public  void  testb1(){
		log(TimeUnit.SECONDS.toNanos(1));
	}
	@Test
	public  void testa(){
		File f=new File("./");
		log(f);
		try {
			File hf=f.getCanonicalFile();
			File hf2=f.getAbsoluteFile();
			log(hf);
			log(hf2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 File f2 = new File(System.getProperty("user.dir"), "..");
         try {
        	 File homeFile = f2.getCanonicalFile();
        	 log(homeFile);
        	 log(homeFile.getPath());
         } catch (IOException ioe) {
        	 File  homeFile = f2.getAbsoluteFile();
        	 log(homeFile);
         }
	}
	@Test
	public void testb(){
		StringBuilder builder = new StringBuilder();
		builder.append("${",0,0);
//		builder.append("sdfgsf${",0,1);
		log(builder);
	}
	@Test
	public void testUserDir(){
		log(System.getProperty("user.dir"));
	}
	@Test
	public void testa2() {
		MyTest t2=new MyTest();
	}
	@Test
	public void testa1() {
		String msg1="sfsf";
		System.out.println("blockbefore:"+msg1);
		{
			String msg2="sgdfgdf";
			System.out.println(msg1);
			System.out.println(msg2);
		}
		String msg2="ngvgfjhgjgjg";
		System.out.println("blockafter:"+msg2);

	}
	@Test
	public void testUrl(){
		 try {
			 String path="D:\\ym10177\\workspaces\\test";
			 path="file:///D:\\soft\\apache-tomcat-7.0.69/lib/*.jar";
			new URL(path);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testpri(){
		log(Boolean.TYPE==boolean.class);
		log(Boolean.class==Boolean.TYPE);
	}
}
