package com.practice.monitorAp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.monitorAp.service.MonitorApService;

@RestController
public class MonitorApController {
	
	@Autowired
	private MonitorApService service;
	
	@GetMapping("/apStatus")
	public String getApStatus() {
		return service.getConnectionInfo();
	}
}
