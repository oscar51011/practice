package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.practice.model.User;

@Mapper
public interface UserMapper {
	public User getUserByUserName(String name);
}
