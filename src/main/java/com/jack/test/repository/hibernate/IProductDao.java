package com.jack.test.repository.hibernate;

import java.math.BigDecimal;
import java.util.List;

import com.jack.test.domain.Product;

public interface IProductDao {

	Product queryById(Long id);

	List<Product> queryByPrice(BigDecimal lowerPrice, BigDecimal upperPrice);

}
