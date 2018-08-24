package com.jack.test.spring;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.jack.test.domain.Product;
import com.jack.test.repository.hibernate.IProductDao;

public class ProductDaoTest extends AbstractSpringTest {
	@Autowired
	private IProductDao productDao;
	@Test
	public void testb() {
		List<Product> products=productDao.queryByPrice(BigDecimal.valueOf(80000), BigDecimal.valueOf(90000));
		log(JSON.toJSONString(products));
	}
	@Test
	public void testa() {
		Product product=productDao.queryById(1l);
		log(JSON.toJSONString(product));
	}
}
