package com.gcu.service;

import org.springframework.stereotype.Service;

import com.gcu.model.UserModel;

//define the service class for user registration
@Service
public class RegistrationService {
	public void registerUser(UserModel userModel) {
		/**
		 * method prints a message indicating the registration of a user
         * next milestones => we would typically persist the user's information in a database
		 */
		System.out.println("Registered User: " + userModel.getUsername());
	}
}
