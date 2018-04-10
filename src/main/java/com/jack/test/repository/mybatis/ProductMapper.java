package com.jack.test.repository.mybatis;

import com.jack.test.domain.Product;

public interface ProductMapper {
	
	int insert(Product product);

	int update(Product product);

	Product queryById(Long id);
}
