package com.jack.test;

import org.junit.Test;

import com.jack.test.util.Utils;

public class UtilsTest extends BaseTest {
	@Test
	public void testMaping() {
		StringBuilder sb=new StringBuilder();
		String[] aliases={"ID","NAME","ID_CARD"};
		int i=0;
		for(String alias:aliases){
			log(Utils.columnToProperty(alias, sb));
		}
		String[] properties={"id","name","idCard","ADSsfsDggh"};
		for(String property:properties){
			log(Utils.propertyToColumn(property, sb));
		}
	}

}
