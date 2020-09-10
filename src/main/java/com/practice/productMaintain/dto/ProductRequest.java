package com.practice.productMaintain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("取得商品資訊Request")
public class ProductRequest {
	
	@ApiModelProperty("商品貨號")
	private String skuNumber;

	public String getSkuNumber() {
		return skuNumber;
	}

	public void setSkuNumber(String skuNumber) {
		this.skuNumber = skuNumber;
	}
	
}
