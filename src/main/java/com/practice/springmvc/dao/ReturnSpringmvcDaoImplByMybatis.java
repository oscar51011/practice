package com.practice.springmvc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.practice.mapper.ReturnSpringmvcMapper;
import com.practice.springmvc.model.PersonModel;

@Repository
public class ReturnSpringmvcDaoImplByMybatis implements ReturnSpringmvcDao {

	@Autowired
	private ReturnSpringmvcMapper mapper;
	
	@Override
	public PersonModel getPersonById(int id) {
		return mapper.getPersonById(id);
	}
	
}
