package com.codingfly.RestaurentManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingfly.RestaurentManagement.DTO.Restaurent;

public interface RestaurentRepository extends JpaRepository<Restaurent, Integer> { 
	public Restaurent findByName(String name);
}
