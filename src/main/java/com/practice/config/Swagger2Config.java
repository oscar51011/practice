package com.practice.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()
          // 可以透過掃特定 package 顯示
          .apis(RequestHandlerSelectors.any())
          // 可以掃特定的 url 才顯示於 swagger ( 只顯示api開頭的 Rest API )
          .paths(PathSelectors.ant("/api/**"))
          .build()
          .apiInfo(apiInfo())
          .globalOperationParameters(globalParameterList())
          ;                                           
    }
	
	// 配置 swagger 畫面訊息
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Practice API規格")
				.description("練習用Swagger呈現API規格")
				.build()
				;
	}
	
	// 實作 api header 設置 token
	private List<Parameter> globalParameterList() {
	     
    		Parameter authTokenHeader = new ParameterBuilder()
            .name("Authorization") // name of the header
            .modelRef(new ModelRef("string")) // data-type of the header
            .required(true) // required/optional
            .parameterType("header") // for query-param, this value can be 'query'
            .description("Authorization")
            .build();
    		
    		return Collections.singletonList(authTokenHeader);
	}
}
