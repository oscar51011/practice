package com.practice.productMaintain.dao;

import com.practice.productMaintain.model.ProductModel;

public interface MaintainProductDao {
	public int saveProduct(ProductModel product);
	public ProductModel getProductBySkuNumber(String skuNumber);
	public int updateProudct(ProductModel product);
	public int deleteProductById(int productId);
}
