package com.practice.productMaintain.model;

import java.io.Serializable;

public class ProductModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4181857961244131460L;
	
	private int productId;
	private String skuNumber;
	private String skuName;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getSkuNumber() {
		return skuNumber;
	}
	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}
	public String getSkuName() {
		return skuName;
	}
	public void setSkuName(String skuName) {
		this.skuName = skuName;
	}
}
