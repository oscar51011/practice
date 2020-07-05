package com.practice.monitorAp.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MonitorApService {
	
	@Value("${ap.enviroment}")
	private String apEnviroment;

	public String getConnectionInfo() {
		return apEnviroment;
	}
}
