package com.practice.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/","/home"})
	private String getHome(Model model) {
		return "home.html";
	}
	
	@GetMapping("/login")
	private String geLoginPage(Model model) {
		return "login.html";
	}
}
