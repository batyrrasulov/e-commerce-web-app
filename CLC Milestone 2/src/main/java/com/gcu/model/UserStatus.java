package com.gcu.model;

public class UserStatus {

	private boolean login;
	private boolean admin;
	private String name;
	
	public UserStatus() 
	{
		login = false;
		admin = false;
		name = "";
	}

	public boolean isLogin() {
		return login;
	}

	public void setLogin(boolean login) {
		this.login = login;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
