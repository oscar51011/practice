package com.practice.productMaintain.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.practice.mapper.MaintainProductMapper;
import com.practice.productMaintain.model.ProductModel;

@Component("maintainProductDaoImplMybatis")
public class MaintainProductDaoImplMybatis implements MaintainProductDao {
	
	@Autowired
	private MaintainProductMapper mapper;
	
	@Override
	public int saveProduct(ProductModel product) {
		return mapper.saveProduct(product);
	}

	@Override
	public ProductModel getProductBySkuNumber(String skuNumber) {
		return mapper.findProductBySkuNumber(skuNumber);
	}

	@Override
	public int updateProudct(ProductModel product) {
		return mapper.updateProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		mapper.deleteProduct(productId);
	}
	
}
