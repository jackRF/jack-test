package com.jack.test.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jack.test.domain.Product;

public interface ProductMapper {
	
	int insert(Product product);

	int update(Product product);

	Product queryById(Long id);

	List<Product> queryByCode(@Param("codes") String[] codes);
}
