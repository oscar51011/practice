package com.practice.apConnection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.apConnection.service.ApConnectionService;

@RestController
public class ApConnectionController {
	
	@Autowired
	private ApConnectionService service;
	
	@GetMapping("/apStatus")
	public String test() {
		return service.getConnectionInfo();
	}
}
