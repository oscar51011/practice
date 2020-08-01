package com.practice.springmvc.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.practice.PracticeApplication;
import com.practice.productMaintain.dao.MaintainProductDaoImplMybatis;
import com.practice.springmvc.model.PersonModel;

@SpringBootTest(classes = {PracticeApplication.class})
class ReturnSpringmvcDaoImplByMybatisTest {

	@Autowired
	private ReturnSpringmvcDao dao;
	
	@Test
	void testGetPersonByIdPersonNameIsEquals() {		
		assertDoesNotThrow(
				() -> dao.getPersonById(1)
		);		
	}

}
