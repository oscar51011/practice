package com.practice.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Set up and use properties in spring
 * reference : https://www.baeldung.com/properties-with-spring
 * @author 林聖凱
 *
 */
@Configuration
public class PropertiesConfig {

	@Bean
	public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() throws IOException {
		PropertySourcesPlaceholderConfigurer propertyConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyConfigurer.setLocations(
				new PathMatchingResourcePatternResolver()
				.getResources("classpath:practice/properties/*.properties")
		);
		return  propertyConfigurer;
	}
	
}
