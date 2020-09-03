package com.practice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 設定 Redis config
 * TODO: 參數可以抽到 properties
 * @author 林聖凱
 *
 */
@Configuration
public class RedisConfig {
	
	/**
	 * Spring-data-redis 2.0後改用 RedisStandaloneConfiguration
	 * 而非 setHostName & setPort 等方法
	 */
	@Bean
	public LettuceConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration("127.0.0.1", 6379);
		
		LettuceConnectionFactory factory = new LettuceConnectionFactory(configuration);
		
		return factory;
	}
	
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		
		template.setConnectionFactory(redisConnectionFactory());
		
		/**
		 * 解決亂碼問題，stringRedisSerializer 序列化方式為 UTF-8 
		 */
		StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
		template.setKeySerializer(stringRedisSerializer);
		template.setHashKeySerializer(stringRedisSerializer);
		template.setValueSerializer(stringRedisSerializer);
		template.setHashValueSerializer(stringRedisSerializer);
		
		return template;
	}
}
