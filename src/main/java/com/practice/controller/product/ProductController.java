package com.practice.controller.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

	@GetMapping("/product")
	public String getProductViewPage(Model model) {
		return "product/productView.html";
	}
}
