package com.practice.monitorAp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.mapper.MonitorApMapper;

@Repository("monitorApDaoImplByMybatis")
public class MonitorApDaoImplByMybatis implements MonitorApDao {

	@Autowired
	private MonitorApMapper mapper;
	
	@Override
	public int getDbConnection() {
		return mapper.getDbConnection();	
	}
		
}
