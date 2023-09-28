package com.gcu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gcu.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long>{
}
