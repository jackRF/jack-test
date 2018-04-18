package com.jack.test.repository.hibernate.impl;


import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.jack.test.domain.Product;
import com.jack.test.repository.hibernate.IProductDao;

@Repository
public class ProductDaoImpl extends AbstractDaoImpl implements IProductDao {
	@Override
	public Product queryById(Long id) {
		return (Product) getSession().get(Product.class, id);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Product> queryByPrice(BigDecimal lowerPrice,BigDecimal upperPrice) {
		Query query = getSession().createQuery("select p from Product p where price>=:lowerPrice and price<=:upperPrice "); 
		query.setParameter("lowerPrice", lowerPrice);
		query.setParameter("upperPrice", upperPrice);
		return query.list();

	}
}
