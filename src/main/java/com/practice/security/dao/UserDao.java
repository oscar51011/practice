package com.practice.security.dao;

import com.practice.model.User;

public interface UserDao {
	User getUserByUserName(String name);
}
