package com.gcu.service;

import org.springframework.stereotype.Service;

// define the service class for user authentication
@Service
public class LoginService {
	public boolean authenticateUser(String username, String password) {
		/**
		 * method simulates authentication by checking username and password
         * next milestones < we would typically perform authentication against a database
		 */
		return "user".equals(username) && "password".equals(password);
	}
}
