package com.codingfly.RestaurentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfly.RestaurentManagement.DTO.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public User findByPhone(String phone);
}
