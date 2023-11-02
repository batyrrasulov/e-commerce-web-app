package com.gcu.service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import com.gcu.model.UserStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
    private final UserRepository userRepository;
    @Autowired
    private UserStatus userStatus;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticateUser(String username, String password) {
        UserEntity user = userRepository.findByUsername(username);
        if( user != null && user.getPassword().equals(password))
        {
        	userStatus.setLogin(true);
        	userStatus.setName(username);
        	userStatus.setAdmin(user.isAdmin());
        	return true;
        }
        return false;
    }
}
