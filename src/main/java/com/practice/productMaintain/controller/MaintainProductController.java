package com.practice.productMaintain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/maintainProduct")
public class MaintainProductController {

	@GetMapping("/product")
	public String getProductViewPage(Model model) {
		return "product/productView.html";
	}
}