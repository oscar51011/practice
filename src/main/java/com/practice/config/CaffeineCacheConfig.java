package com.practice.config;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.CacheLoader;
import com.practice.practiceCacahe.content.CaffeineCacheConstants;


/**
 * 引入  Cache機制
 * @author 林聖凱
 *
 */
@Configuration
@EnableCaching
public class CaffeineCacheConfig {
	
	@Value("${spring.cache.caffeine.spec}")
	private String caffeineSpec;
	
	/**
	 * 使用 Caffeine Cache實作 接上 Spring CacheManager interface
	 * @return
	 */
	@Bean(CaffeineCacheConstants.CAFFEINE_CACHE)
	public CacheManager caffeineCacheManager() {
		/**
		 * TODO:
		 * 不明白 CacheLoader 機制
		 */
		final CacheLoader<Object, Object> cacheLoader = new CacheLoader<Object, Object>(){

			@Override
			public @Nullable Object load(@NonNull Object key) throws Exception {
				return null;
			}

			@Override
			public Object reload(Object key, Object oldValue) throws Exception {
				return oldValue;
			}
					
		};
						
		CaffeineCacheManager caffeineCacheManager = new CaffeineCacheManager();
		caffeineCacheManager.setCacheLoader(cacheLoader);
	    caffeineCacheManager.setCacheSpecification(caffeineSpec);
	    return caffeineCacheManager;
	}
}
