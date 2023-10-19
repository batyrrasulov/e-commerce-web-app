package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gcu.model.*;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@GetMapping("/creation")
	public String creation(Model model)
	{
		model.addAttribute("title", "Product Creation");
		
		if (!model.containsAttribute("productModel")) {
            model.addAttribute("productModel", new Product());
        }
		
		return "productCreation";
	}
	
	@PostMapping("/doCreation")
	public String doCreation(@ModelAttribute("productModel") @Valid Product productModel, BindingResult bindingResult, Model model) 
	{
		if (bindingResult.hasErrors()) {
            return "productCreation";
        }
		ObjectMapper mapper = new ObjectMapper();

		String json = "";
		try {
			json = mapper.writeValueAsString(productModel);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n" + json +"\n");
		
		return "redirect:/";
	}
}
