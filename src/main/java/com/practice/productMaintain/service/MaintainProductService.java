package com.practice.productMaintain.service;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import com.practice.exception.RedisOperationException;
import com.practice.productMaintain.dao.MaintainProductDao;
import com.practice.productMaintain.model.ProductModel;

@Service
public class MaintainProductService {
	
	private static Logger logger = LoggerFactory.getLogger(MaintainProductService.class);
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private MaintainProductDao maintainProductDao;
	
	
	@SuppressWarnings("unchecked")
	public String getProductNameBySkuNumber(String skuNumber) {
		
		String skuName = null;
		
		// 1.檢查是否存在 redis
		if(redisTemplate.hasKey(skuNumber)) {
			
			logger.info("redis有資料，直接redis取得");
			
			try {
				redisTemplate.setValueSerializer(new StringRedisSerializer());
		        	ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
		        
		        	skuName = (String) operations.get(skuNumber);
		        
		        logger.info("商品顯示:" + skuName);
		        	        
			} catch(Exception e) {
				logger.error("get redis異常" + e);
				throw new RedisOperationException("get redis error!", e);
			}
				
		} else {
			
			logger.info("進入 DB查詢資料");	
			ProductModel product = maintainProductDao.getProductBySkuNumber(skuNumber);
			
			try {
				logger.info("將查出來的資料放進redis中");
				ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
				operations.set(skuNumber, product.getSkuName());
			}catch(Exception e) {
				logger.error("set redis異常" + e);
				throw new RedisOperationException("set redis error!", e);
			}
			
			skuName = product.getSkuName();
		}
		
		return skuName;
	}

}
