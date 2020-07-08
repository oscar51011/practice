package com.practice.monitorAp.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.practice.monitorAp.dao.MonitorApDao;

@Service
public class MonitorApService {
	
	private static final String AP_CONNECTION_SUCCESS_STR = "SUCCESS";
	private static final String AP_CONNECTION_FAILED_STR = "FAILED";
	
	@Value("${ap.enviroment}")
	private String apEnviroment;
	
	@Qualifier("monitorApDaoImplByMybatis")
	@Autowired
	private MonitorApDao monitorApDao;

	public Map<String, String> getConnectionInfo() {
		
		Map<String, String> apInfoMap = new HashMap<String, String>();
		apInfoMap.put("enviroment", apEnviroment);

		int dbConnection = monitorApDao.getDbConnection();
		if(dbConnection == 1) apInfoMap.put("dbConnection",AP_CONNECTION_SUCCESS_STR);
		else apInfoMap.put("dbConnection",AP_CONNECTION_FAILED_STR);
		
		return apInfoMap;
	}
}
