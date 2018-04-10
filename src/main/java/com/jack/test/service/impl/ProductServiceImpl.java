package com.jack.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jack.test.domain.Product;
import com.jack.test.repository.mybatis.ProductMapper;
import com.jack.test.service.IProductService;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductMapper productMapper;
	@Transactional
	@Override
	public int insert(Product product) {
		return productMapper.insert(product);
	}

	@Override
	public int update(Product product) {
		return productMapper.update(product);
	}

}
