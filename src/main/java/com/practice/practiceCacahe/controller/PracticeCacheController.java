package com.practice.practiceCacahe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.practiceCacahe.service.PracticeCacheService;

@Controller
public class PracticeCacheController {

	@Autowired
	private PracticeCacheService service;
	
	@GetMapping(value="getPracticeCacheProductName" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getProductBySkuNumber(@RequestParam("skuNumber") String skuNumber) {
		
		System.out.println("skuNumber: " + skuNumber);
		
		return service.getProductNameBySkuNumber(skuNumber);
	}
	
	@GetMapping(value="clearProductBySkuNumberCache" ,produces = "application/json; charset=utf-8")
	@ResponseBody
	public String clearProductBySkuNumberCache() {
		service.clearProductCache();
		return "SUCCESS";
	}
	
}
