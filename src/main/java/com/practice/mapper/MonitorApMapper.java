package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface MonitorApMapper {
	int getDbConnection();
}
