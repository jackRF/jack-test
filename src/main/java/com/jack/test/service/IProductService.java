package com.jack.test.service;

import com.jack.test.domain.Product;

public interface IProductService {
	
	int insert(Product product);

	int update(Product product);
}
