package com.practice.springmvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.JsonObject;
import com.practice.springmvc.model.PersonModel;
import com.practice.springmvc.service.ReturnSpringmvcService;

/**
 * TODO : 統一的 Handler 要怎麼處理
 * 練習 SpringMvc的 Controller
 * @author 林聖凱
 *
 */
@RestController
@RequestMapping("/springmvcResponse")
public class ReturnSpringmvcResponseController {
	
	private static Logger logger = LoggerFactory.getLogger(ReturnSpringmvcResponseController.class);

	@Autowired
	private ReturnSpringmvcService service;
	
	
	/**
	 * 取得 Person 物件 以 Json 格式回傳
	 * @RequestParam 由 request 拿參數
	 * @return
	 */
	@GetMapping(value="/getPersonByIdAsJson", produces= {"application/json;charset=UTF-8"})
	public ResponseEntity<Object> getPersonByIdAsJsonFormat(@RequestParam("id") int id) {
		
		logger.info("查詢流水碼:"+ id);
				
		PersonModel person = service.getPersonById(id);

		if(person == null)
			return ResponseEntity.status(HttpStatus.OK).body(person);
		else {
			JsonObject personNotFound = new JsonObject();
			personNotFound.addProperty("errorMessage", "此ID:"+ id+"查無此人");
			return ResponseEntity.status(HttpStatus.OK).body(personNotFound.toString());
		}
	}
	
	/**
	 * 取得 Person 物件 以 Xml 格式回傳
	 * TODO: 針對解析異常的回傳 & 找不到ID的人訊息回傳
	 * XML 解析:
	 * https://www.baeldung.com/jackson-xml-serialization-and-deserialization
	 * @return
	 */
	@GetMapping(value="/getPersonByIdAsXml", produces= {"application/xml;charset=UTF-8"})
	public String getPersonByIdAsXmlFormat(@RequestParam("id") int id) {
		logger.info("查詢流水碼:"+ id);
		PersonModel person = service.getPersonById(id);
		return service.transferPersonToXmlFormatAsString(person);
	}
	
	/**
	 * 取得 Person 物件 以 Json 格式回傳
	 * @PathVariable 由 URL樣板填入
	 * @return
	 */
	@GetMapping(value="/getPersonByIdAsJson/{name}", produces= {"application/json;charset=UTF-8"})
	public PersonModel getPersonByIdAsJsonFormat(@PathVariable(value="name") String name) {
		
		logger.info("查詢姓名:"+ name);
		
		PersonModel person = new PersonModel();
		person.setId(1);
		person.setName("test");
		person.setSex("男");
		person.setAge(10);
		
		return person;
	}
	

	
	
}
