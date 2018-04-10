package com.jack.test.spring;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.jack.test.domain.Product;
import com.jack.test.repository.mybatis.ProductMapper;
import com.jack.test.service.IProductService;
@ContextConfiguration(locations={"classpath:spring/spring-*.xml"})
public class ProductServiceTest  extends AbstractJUnit4SpringContextTests{
	@Autowired
	private IProductService productService;
	@Test
	public void test1() {
		Product product=new Product();
		product.setCode("0003");
		product.setName("iphone 8");
		product.setFlag(0l);
		product.setPrice(BigDecimal.valueOf(7188));
		product.setCreateTime(new Date());
		product.setModifyTime(product.getCreateTime());
		productService.insert(product);
		throw new RuntimeException("测试事务");
	}

}
