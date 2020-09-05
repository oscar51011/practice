package com.practice.security.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.PracticeApplication;
import com.practice.springmvc.dao.ReturnSpringmvcDao;

@SpringBootTest(classes = {PracticeApplication.class})
class UserDaoImplByMybatisTest {

	@Autowired
	private UserDao dao;
	
	@Test
	void testGetUserByUserNameIsWork() {		
		assertDoesNotThrow(
				() -> dao.getUserByUserName("user123")
		);		
	}

}
