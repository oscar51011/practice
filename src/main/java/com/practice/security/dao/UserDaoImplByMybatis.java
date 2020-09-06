package com.practice.security.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.mapper.UserMapper;
import com.practice.model.User;

@Repository
public class UserDaoImplByMybatis implements UserDao {
	
	@Autowired
	private UserMapper mapper;

	@Override
	public User getUserByUserName(String name) {
		return mapper.getUserByUserName(name);
	}
	
}
