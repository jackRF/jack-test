package com.jack.test.spring;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jack.test.domain.Product;
import com.jack.test.repository.mybatis.ProductMapper;
import com.jack.test.service.biz.IProductBizService;

public class ProductBizServiceTest extends AbstractSpringTest{
	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private IProductBizService productBizService;
	@Test
	public void testAdditionRecords() {
		log(productMapper.additionRecords(1423573l));
	}
	@Test
	public void testProcessProduct() {
		Product product=productMapper.queryById(1l);
		product.setModifyTime(new Date());
		product.setPrice(BigDecimal.valueOf(8299));
		productBizService.processProduct(product);
	}
	@Test
	public void testProcessProduct2() {
		Product product=productMapper.queryById(1l);
		product.setModifyTime(new Date());
		product.setPrice(BigDecimal.valueOf(8299));
		productBizService.processProduct2(product);
	}
	@Test
	public void testProcessProduct3() {
		Product product=productMapper.queryById(1l);
		product.setModifyTime(new Date());
		product.setPrice(BigDecimal.valueOf(8299));
		productBizService.processProduct3(product);
	}
	@Test
	public void testProcessProduct4() {
		productBizService.processProduct4(1l);
	}
}
