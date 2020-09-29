package com.practice.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.practice.springmvc.model.PersonModel;

@Mapper
public interface ReturnSpringmvcMapper {
	PersonModel getPersonById(@Param("id")int id);
}
