package com.jack.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;


public class URLTest extends BaseTest{
	@Test
	public void testa() {
		String repository="D:\\temp\\sfsdf!\\sfs.txt";
		try {
			
			File file=new File(repository); 
			String uri=file.toURI().toString();
			log(uri);
			log(file.toURI().toURL().toString());
			log(new URL(uri.replaceAll("!/", "%21/")));
//			URL url = new URL(repository);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			Assert.fail();
		}

	}
}
