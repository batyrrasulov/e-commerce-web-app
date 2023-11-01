package com.gcu.controller;

import com.gcu.model.LoginModel;
import com.gcu.model.UserStatus;
import com.gcu.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
	  private final LoginService loginService;
	    // DI => inject the LoginService into the controller
	    @Autowired
	    public LoginController(LoginService loginService) {
	        this.loginService = loginService;
	    }
	    
	    @Autowired
	    private UserStatus user;

	    @GetMapping("/login")
	    public String display(Model model) {
	        model.addAttribute("title", "Login Form");
	        model.addAttribute("loginModel", new LoginModel());
	        return "login";
	    }

	    @PostMapping("/doLogin")
	    public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
	        if (bindingResult.hasErrors()) {
	            model.addAttribute("title", "Login Form");
	            return "login";
	        }
	        // authenticate the user using the injected LoginService
	        if (loginService.authenticateUser(loginModel.getUsername(), loginModel.getPassword())) {
	        	// home page redirection
	        	user.setName(loginModel.getUsername());
	        	user.setAdmin(true);
	        	user.setLogin(true);
	            return "redirect:/"; 
	        } else {
	            model.addAttribute("loginError", "Invalid username or password");
	        	// login page redirection
	            return "login";
	        }
	    }
}
