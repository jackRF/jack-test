package com.jack.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import com.jack.test.util.Utils;

public class UtilsTest extends BaseTest {
	@Test
	public void testaa12() {
		this.setDescription("sfsf");
		log(getDescription());
	}
	void setDescription(String description) {
		log("UtilsTest.setDescription");
	}
	@Test
	public void testaa11() {
		LangTest test=new LangTest();
		test.testb();
	}
	@Test
	public void testa2() {
		List<String> list=Collections.unmodifiableList(Arrays.asList("java.properties"));
		List<String> li2=new ArrayList<String>();
		li2.add("java.properties");
		log(list.getClass());
		log(li2.getClass());
		log(li2.getClass().equals(list.getClass()));
		log(list.equals(li2));
	}
	@Test
	public void testaa1() {
		StringBuilder sb=new StringBuilder();
		sb.append("sfd");
		sb.append("897");
		StringBuilder sb2=new StringBuilder();
//		sb2.append("s");
//		sb2.append("fd8");
//		sb2.append("97");
		sb2.append("sfd");
		sb2.append("897");
		log(sb2.toString()==sb.toString());
		log(sb2.toString().equals(sb.toString()));
	}
	@Test
	public void testaa() {
		log(Boolean.valueOf(null));
		log(Boolean.valueOf(""));
		log(Boolean.valueOf("fhfhf"));
		log(Boolean.valueOf("true"));
		log(Boolean.valueOf("True"));
		log(Boolean.valueOf("TrUe"));
	}
	@Test
	public void testMaping() {
		StringBuilder sb=new StringBuilder();
		String[] aliases={"ID","NAME","ID_CARD","ADSSFS_DGGH_DDGF"};
		for(String alias:aliases){
			log(Utils.columnToProperty(alias, sb));
		}
		String[] properties={"id","name","idCard","ADSsfsDgghDDgf"};
		for(String property:properties){
			log(Utils.propertyToColumn(property, sb));
		}
	}

}
