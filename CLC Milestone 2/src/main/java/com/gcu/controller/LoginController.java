package com.gcu.controller;

import com.gcu.model.LoginModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class LoginController {
	@GetMapping("/login")
	public String display(Model model) {
		// create a new instance of a LoginModel
		LoginModel loginModel = new LoginModel();
		// set model attributes
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", loginModel);
		// return the view named "login"
		return "login";
	}
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
		// check for the validation errors
		if (bindingResult.hasErrors()) {
			model.addAttribute("title", "Login Form");
			return "login";
		}
		// print the form values out
		System.out.println(String.format("Form with Username of %s and Password of %s", loginModel.getUsername(), loginModel.getPassword()) );

		return "redirect:/";
	}
}
