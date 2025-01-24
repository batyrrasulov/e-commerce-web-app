package com.gcu.service;

import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final UserRepository userRepository;

    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void registerUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
