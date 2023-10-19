package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.model.UserStatus;
import com.gcu.service.LoginService;
import com.gcu.service.RegistrationService;

// define a configuration class
@Configuration
public class AppConfig {
	// define bean methods
    @Bean(name="businessLoginService")
    public LoginService businessLoginService() {
    	return new LoginService();
    }
    @Bean(name="businessRegistrationService")
    public RegistrationService businessRegistrationService() {
    	return new RegistrationService();
    }
    
    @Bean(name="userStatus")
    @SessionScope
    public UserStatus userStatus() {
    	return new UserStatus();
    }
}
