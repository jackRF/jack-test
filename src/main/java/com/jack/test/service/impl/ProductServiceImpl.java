package com.jack.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
	@Transactional
	@Override
	public int update(Product product) {
		return productMapper.update(product);
	}
	@Override
	public Product queryById(Long id){
		return productMapper.queryById(id);
	}
	@Override
	public List<Product> queryByCode(String...codes){
		return productMapper.queryByCode(codes);
	}
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	@Override
	public int forceInsert(Product product) {
		 return productMapper.insert(product);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public int updateFlag(Product product,long flag) {
		product.setFlag(flag);
		return productMapper.update(product);
	}
}
