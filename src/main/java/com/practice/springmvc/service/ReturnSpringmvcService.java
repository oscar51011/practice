package com.practice.springmvc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.JsonObject;
import com.practice.springmvc.dao.ReturnSpringmvcDao;
import com.practice.springmvc.model.PersonModel;

@Service
public class ReturnSpringmvcService {
	
	private static Logger logger = LoggerFactory.getLogger(ReturnSpringmvcService.class);
	
	@Autowired
	private ReturnSpringmvcDao returnSpringmvcDao;
	
	
	public PersonModel getPersonById(int id) {
		return returnSpringmvcDao.getPersonById(id);
	}
	
	/**
	 * TODO: 處理 RuntimeException 統一控管
	 * 將 PersonModel 轉成  XML格式
	 * @param person
	 * @return
	 */
	public String transferPersonToXmlFormatAsString(PersonModel person) {
		
		XmlMapper xmlMapper = new XmlMapper();
		
		String xmlData = "";
		
		try {
			if(person != null) {
				xmlData = xmlMapper.writeValueAsString(person);
			} else {
				xmlData = xmlMapper.writeValueAsString(getPersonNotFoundMessage());
			}		
		} catch (JsonProcessingException e) {
			logger.error("XML解析異常"+ e);
			throw new RuntimeException("系統解析XML異常,請稍後再試");
		}
		return xmlData;
	}
	
	/**
	 * 如果找不到使用者，回復此ID查無此人
	 * @return
	 */
	private String getPersonNotFoundMessage() {
		JsonObject personNotFound = new JsonObject();
		personNotFound.addProperty("errorMessage", "此ID查無此人");
		return personNotFound.toString();
	}
	
}
