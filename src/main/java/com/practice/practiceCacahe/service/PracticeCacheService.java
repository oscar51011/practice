package com.practice.practiceCacahe.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.practice.mapper.MaintainProductMapper;
import com.practice.practiceCacahe.content.CaffeineCacheConstants;
import com.practice.productMaintain.model.ProductModel;

@CacheConfig(cacheNames=CaffeineCacheConstants.SKU_NAME_CACHE)
@Service
public class PracticeCacheService {
	
	private static Logger logger = LoggerFactory.getLogger(PracticeCacheService.class);
	
	@Autowired
	private MaintainProductMapper mapper;
	
	/**
	 * 取得商品名稱，使用 cache
	 * @param skuNumber
	 * @return
	 */
	@Cacheable(key="#skuNumber")
	public String getProductNameBySkuNumber(String skuNumber) {
		
		logger.info("input:"+ skuNumber);
		
		ProductModel person = mapper.findProductBySkuNumber(skuNumber);
		String productName = person.getSkuName();
		
		logger.info("取得DB商品名稱:" + productName);
		
		return productName;
	}
	
	/**
	 * 清空 SKU_NAME_CACHE 的值 ( allEntries default : false )
	 */
	@CacheEvict(allEntries=true)
	public void clearProductCache() {
		
	}
	
	
}
