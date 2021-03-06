package com.jack.test.service.biz.impl;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jack.test.domain.Product;
import com.jack.test.service.IProductService;
import com.jack.test.service.biz.IProductBizService;

@Service
public class ProductBizServiceImpl implements IProductBizService{
	@Autowired
	private IProductService productService;
	@Transactional
	@Override
	public void processProduct(Product product) {
		productService.update(product);
		productService.updateFlag(product, 7);
		throw new RuntimeException("测试事务的传播");
	}
	@Transactional
	@Override
	public void processProduct2(Product product) {
		productService.update(product);
		product.setCode("0010");
		productService.forceInsert(product);
		throw new RuntimeException("测试事务的传播");
	}
	@Transactional
	@Override
	public void processProduct3(Product product) {
		productService.update(product);
		product.setCode("0020");
		productService.insert(product);
		throw new RuntimeException("测试事务");
	}
	@Transactional
	@Override
	public void processProduct4(Long id) {
		Product product=productService.queryById(id);
		product.setModifyTime(new Date());
		productService.updateFlag(product, 9);
		System.out.println("end updateFlag");
		product.setPrice(product.getPrice().add(BigDecimal.valueOf(200)));
		productService.update(product);
	}
}
