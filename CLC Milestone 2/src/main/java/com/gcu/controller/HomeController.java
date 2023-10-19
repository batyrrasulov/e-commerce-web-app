package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gcu.model.UserStatus;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String Home(Model model)
	{
		model.addAttribute("title", "Home");
		
		return "index";
	}
}
