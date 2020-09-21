package com.practice.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 練習回傳 view 的 controller
 * @author 林聖凱
 *
 */
@Controller
@RequestMapping("/springmvcView")
public class ReturnSpringmvcViewController {
	
	@GetMapping("/getSpringmvcView")
	public String getSpringmvcView(){
		return "springmvc/springmvcView.html";
	}
	
}
