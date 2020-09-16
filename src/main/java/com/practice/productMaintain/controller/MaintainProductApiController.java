package com.practice.productMaintain.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.productMaintain.dto.ProductRequest;
import com.practice.productMaintain.service.MaintainProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="MaintainProductApiController")
@Controller
@RequestMapping("/api/maintainProduct")
public class MaintainProductApiController {
	
	private static Logger logger = LoggerFactory.getLogger(MaintainProductController.class);
	
	@Autowired
	private MaintainProductService maintainProductService;
	
	@ApiOperation(value ="取得商品資訊", notes="利用商品號碼取得商品資訊")
	@PostMapping(value = "/getProductSkuNumber", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String getSkuNameBySkuNumber(@RequestBody ProductRequest product) {
		
		logger.info("GetSkuNumber Controller Start, skuNumber is:" + product.getSkuNumber());
			
		String name = maintainProductService.getProductNameBySkuNumber(product.getSkuNumber());
		
		logger.info("Controller output:" + name); 
		
		return name;
	}
}
