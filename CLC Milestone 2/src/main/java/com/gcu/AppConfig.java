package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.gcu.service.LoginService;
import com.gcu.service.RegistrationService;

// define a configuration class
@Configuration
public class AppConfig {
	// define bean methods
    @Bean(name="loginService")
    public LoginService loginService() {
    	return new LoginService();
    }
    @Bean(name="registrationService")
    public RegistrationService registrationService() {
    	return new RegistrationService();
    }
}
