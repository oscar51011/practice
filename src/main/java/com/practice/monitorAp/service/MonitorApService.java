package com.practice.monitorAp.service;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practice.monitorAp.dao.MonitorApDao;

@Service
public class MonitorApService {
	
	private static Logger logger = LoggerFactory.getLogger(MonitorApService.class);
	
	private static final String AP_CONNECTION_SUCCESS_STR = "SUCCESS";
	private static final String AP_CONNECTION_FAILED_STR = "FAILED";
	
	@Value("${ap.enviroment}")
	private String apEnviroment;
	
	@Qualifier("monitorApDaoImplByMybatis")
	@Autowired
	private MonitorApDao monitorApDao;

	public Map<String, String> getConnectionInfo() {
		
		Map<String, String> apInfoMap = new HashMap<String, String>();
		
		try {
			apInfoMap.put("enviroment", apEnviroment);
	
			int dbConnection = monitorApDao.getDbConnection();
			if(dbConnection == 1) apInfoMap.put("dbConnection",AP_CONNECTION_SUCCESS_STR);
			else apInfoMap.put("dbConnection",AP_CONNECTION_FAILED_STR);
		} catch (Exception e) {
			apInfoMap.put("dbConnection",AP_CONNECTION_FAILED_STR);
			logger.error("監控AP發生Error:", e);
		}
		
		return apInfoMap;
	}
}
