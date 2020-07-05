package com.practice.monitorAp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.monitorAp.service.MonitorApService;

@RestController
public class MonitorApController {
	
	@Autowired
	private MonitorApService service;
	
	@GetMapping("/apStatus")
	@ResponseBody
	public Map<String, String> getApStatus() {		
		return service.getConnectionInfo();
	}
}
