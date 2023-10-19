package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
}
