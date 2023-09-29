package com.gcu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.gcu.model.UserModel;
import com.gcu.util.DataWriter;

import jakarta.validation.Valid;

@Controller
public class RegistrationController {
    private final DataWriter dataWriter;
    public RegistrationController(DataWriter dataWriter) {
        this.dataWriter = dataWriter;
    }
    @GetMapping("/register")
    public String display(Model model) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", new UserModel());
        }
        return "register";
    }
    @PostMapping("/doRegister")
    public String doRegister(@ModelAttribute("user") @Valid UserModel userModel, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        dataWriter.writeData(userModel);
        return "redirect:/register"; // Redirect to the registration form after successful registration
    }
}