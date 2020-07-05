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
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public int deleteProductById(int productId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
