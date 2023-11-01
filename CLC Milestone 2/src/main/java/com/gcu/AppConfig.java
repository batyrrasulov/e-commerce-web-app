package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import com.gcu.model.UserStatus;

// define a configuration class
@Configuration
public class AppConfig {
    @Bean(name="userStatus")
    @SessionScope
    public UserStatus userStatus() {
    	return new UserStatus();
    }
}
