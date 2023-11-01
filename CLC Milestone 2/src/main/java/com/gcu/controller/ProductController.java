package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.gcu.model.*;
import com.gcu.service.ProductService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/creation")
	public String creation(Model model)
	{
		model.addAttribute("title", "Product Creation");
		
		if (!model.containsAttribute("productModel")) {
            model.addAttribute("productModel", new ProductModel());
        }
		
		return "productCreation";
	}
	
	@PostMapping("/doCreation")
	public String doCreation(@ModelAttribute("productModel") @Valid ProductModel productModel, BindingResult bindingResult, Model model) 
	{
		if (bindingResult.hasErrors()) {
            return "productCreation";
        }
		service.create(productModel);
		
		return "redirect:/";
	}
}
