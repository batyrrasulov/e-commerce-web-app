package com.gcu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.UserModel;
import com.gcu.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
public class RegistrationController {
	private final RegistrationService registrationService;
    // DI => inject the RegistrationService into the controller
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/register")
    public String display(Model model) {
        model.addAttribute("title", "Register");
        model.addAttribute("user", new UserModel());
        return "register";
    }

    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute("user") @Valid UserModel userModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        // convert UserModel to UserEntity
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userModel.getFirstName());
        userEntity.setLastName(userModel.getLastName());
        userEntity.setEmail(userModel.getEmail());
        userEntity.setPhoneNumber(userModel.getPhoneNumber());
        userEntity.setUsername(userModel.getUsername());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userModel.getPassword()));

        // call the RegistrationService to register the user with the converted UserEntity
        registrationService.registerUser(userEntity);

        // Home page redirection
        return "redirect:/";
    }

}
