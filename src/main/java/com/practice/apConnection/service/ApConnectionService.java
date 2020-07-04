package com.practice.apConnection.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ApConnectionService {
	
	@Value("${ap.enviroment}")
	private String apEnviroment;

	public String getConnectionInfo() {
		return apEnviroment;
	}
}
