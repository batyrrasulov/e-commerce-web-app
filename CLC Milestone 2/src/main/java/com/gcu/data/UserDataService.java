package com.gcu.data;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UserRepository;

@Service
public class UserDataService implements DataAccessInterface<UserEntity> {

    private final UserRepository userRepository;

    @Autowired
    public UserDataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserEntity> findAll() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public UserEntity findbyId(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(UserEntity user) {
        if (user == null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean update(UserEntity user) {
        if (user == null) {
            return false;
        }
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean delete(UserEntity user) {
        if (user == null) {
            return false;
        }
        userRepository.delete(user);
        return true;
    }

	@Override
	public List<UserEntity> getProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}
}
