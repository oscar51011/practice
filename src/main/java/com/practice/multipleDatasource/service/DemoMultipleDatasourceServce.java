package com.practice.multipleDatasource.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.mapper.MaintainProductMapper;
import com.practice.productMaintain.model.ProductModel;
import com.practice.secnodModel.Product;
import com.practice.secnodModel.ProductExample;
import com.practice.secondMapper.ProductMapper;

/**
 * Demo 從不同的 數據源 抓資料並顯示
 * @author 林聖凱
 *
 */
@Service
public class DemoMultipleDatasourceServce {
	
	private static Logger logger = LoggerFactory.getLogger(DemoMultipleDatasourceServce.class);

	@Autowired
	private ProductMapper secondProductMapper;
	
	@Autowired
	private MaintainProductMapper primaryProductMapper;
	
	public void showMultipleDatasourceData() {
		
		ProductModel primaryProduct = primaryProductMapper.findProductBySkuNumber("test1");
		
		logger.info("Primary DataBase ProductName: " + primaryProduct.getSkuName());
		
		Product product = secondProductMapper.selectByPrimaryKey(10);
		
		logger.info("Second DataBase ProductName: " + product.getSkuName());
		
//		ProductExample example = new ProductExample();
//		ProductExample.Criteria crtieria = example.createCriteria();
//		crtieria.andSkuNameEqualTo("test4");
//		List<Product> products = secondProductMapper.selectByExample(example);
//		for(Product product : products) {
//			logger.info("Second DataBase ProductName: " + product.getSkuName());
//		}
		
	}
}
