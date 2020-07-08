package com.practice.monitorAp.dao;

import org.springframework.stereotype.Repository;

@Repository("monitorApDaoImplByMybatis")
public class MonitorApDaoImplByMybatis implements MonitorApDao {

	@Override
	public int getDbConnection() {
		return 1;	
	}
		
}
