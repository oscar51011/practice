package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.practice.productMaintain.model.ProductModel;

@Repository
@Mapper
public interface MaintainProductMapper {
	int saveProduct(ProductModel product);
	ProductModel findProductBySkuNumber(@Param("skuNumber")String skuNumber);
	int updateProduct(ProductModel product);
	void deleteProduct(int productId);
}
