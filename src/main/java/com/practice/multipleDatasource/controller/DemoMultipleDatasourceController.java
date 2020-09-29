package com.practice.multipleDatasource.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.multipleDatasource.service.DemoMultipleDatasourceServce;

@Controller
@RequestMapping("/practiceMuitipleDatasouce")
public class DemoMultipleDatasourceController {
	
	@Autowired
	private DemoMultipleDatasourceServce service;
	
	@GetMapping(value="/getProductName")
	@ResponseBody
	public String getProductBySkuNumber() {
		service.showMultipleDatasourceData();
		return "Demo in Console - Success";
	}
	
}
