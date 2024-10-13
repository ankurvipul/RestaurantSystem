package com.codingfly.RestaurentManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingfly.RestaurentManagement.DTO.User;
import com.codingfly.RestaurentManagement.Repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User register(User user) {
		if (repository.findById(user.getId()) == null) {
			repository.save(user);
			return user;
		}
		return null;
	}
	
	public User login(String name, String phone) {
		User user = repository.findByPhone(phone);
		if (user.getName().equals(name)) {
			return user;
		}
		
		return null;
	}
}
