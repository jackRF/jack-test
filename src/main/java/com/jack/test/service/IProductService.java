package com.jack.test.service;

import java.util.List;

import com.jack.test.domain.Product;

public interface IProductService {
	
	int insert(Product product);

	int update(Product product);

	Product queryById(Long id);

	List<Product> queryByCode(String...codes);

	int updateFlag(Product product, long flag);

	int forceInsert(Product product);
}
