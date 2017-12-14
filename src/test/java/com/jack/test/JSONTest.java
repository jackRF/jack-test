package com.jack.test;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.jack.test.bo.suanhua.CreditReportBO;
import com.jack.test.bo.suanhua.PersonBO.Identification;
import com.jack.test.vo.SuanHuaResultVO;

public class JSONTest extends BaseTest {
	@Test
	public void testa() {
		String json;
		try {
			json = readText(new File("./data/temptextdata.txt"));
			log("json:"+json);
			SuanHuaResultVO<CreditReportBO> creditReportResult=JSON.parseObject(json, new TypeReference<SuanHuaResultVO<CreditReportBO>>(){});
			log(creditReportResult.isSuccess());
			CreditReportBO creditReportBO=creditReportResult.getData();
			Identification identification=creditReportBO.Person.identification;
			log(identification.gender);
			log(identification.birthday);
			log(identification.idType);
			log(identification.idCard);
			log(identification.marriage);
			log(identification.eduLevel);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
