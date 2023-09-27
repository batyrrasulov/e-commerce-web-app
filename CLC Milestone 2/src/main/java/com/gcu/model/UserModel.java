package com.gcu.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty(message = "First name is required")
    @Size(min = 1, max = 32, message = "First name must be between 1 and 32 characters")
    private String firstName;
    @NotEmpty(message = "Last name is required")
    @Size(min = 1, max = 32, message = "Last name must be between 1 and 32 characters")
    private String lastName;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Phone number is required")
    private String phoneNumber;
    @NotEmpty(message = "Username is required")
    @Size(min = 1, max = 32, message = "Username must be between 1 and 32 characters")
    private String username;
    @NotEmpty(message = "Password is required")
    private String password;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}    
}
