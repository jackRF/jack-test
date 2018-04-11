package com.jack.test.spring;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.jack.test.domain.Product;
import com.jack.test.service.IProductService;
import com.jack.test.service.impl.ProductServiceImpl;
public class ProductServiceTest  extends AbstractSpringTest{
	@Autowired
	private IProductService productService;
	@Test
	public void test1() {
		log(productService.getClass().equals(ProductServiceImpl.class));
		Product product=new Product();
		product.setCode("0004");
		product.setName("iphone 8");
		product.setFlag(0l);
		product.setPrice(BigDecimal.valueOf(7188));
		product.setCreateTime(new Date());
		product.setModifyTime(product.getCreateTime());
		productService.insert(product);		
	}
	@Test
	public void testUpdate() {
		Product product=productService.queryById(1l);
		product.setPrice(BigDecimal.valueOf(8199));
		product.setModifyTime(new Date());
		productService.update(product);
		
	}
	@Test
	public void testQuery() {
		Product product=productService.queryById(1l);
		log(JSON.toJSONString(product));
	}
	@Test
	public void testQueryList() {
		List<Product> products=productService.queryByCode("0001","0002","0003");
		log(JSON.toJSONString(products));
	}
	
}
