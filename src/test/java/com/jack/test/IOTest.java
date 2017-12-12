package com.jack.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.jack.test.util.ZipUtils;

public class IOTest extends BaseTest {
	@Test
	public void test3() {
		log("sfsfs\\sdfsfs/sfs".lastIndexOf("/"));
	}
	@Test
	public void test2() {
		try {
			ZipUtils.unzip(new File("d:\\temp\\ziptest.zip"), new File("d:\\temp\\unziptest"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void test1() {
		try {
			ZipUtils.zip(new File("d:\\temp\\ziptest.zip"), new File("d:\\temp\\ziptest")
			,new File("d:\\temp\\sss\\adf"),new File("d:\\temp\\sss\\images"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
