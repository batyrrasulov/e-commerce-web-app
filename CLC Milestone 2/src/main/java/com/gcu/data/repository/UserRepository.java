package com.gcu.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.gcu.data.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
