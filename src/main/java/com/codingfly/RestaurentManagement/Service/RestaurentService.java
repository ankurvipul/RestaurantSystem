package com.codingfly.RestaurentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.codingfly.RestaurentManagement.DTO.Order;
import com.codingfly.RestaurentManagement.DTO.Restaurent;
import com.codingfly.RestaurentManagement.DTO.Review;
import com.codingfly.RestaurentManagement.Repository.RestaurentRepository;

public class RestaurentService {
	
	@Autowired
	private RestaurentRepository repository;
	
	public void addReview(Review review) {
		Restaurent restaurent = repository.findByName(review.getName());
		restaurent.getReviews().add(review);
		repository.save(restaurent);
	}
	
	public Restaurent register(Restaurent restaurent) {
		if (repository.findByName(restaurent.getName()) != null) {
			return null;
		}
		return repository.save(restaurent);
	}
	
	public Order placeOrder(Order order) {
		Restaurent restaurent = repository.findByName(order.getRestaurentName());
		if (restaurent.getItem().getQuantity() < order.getQuantity()) {
			return null;
		}
		
		restaurent.getOrders().add(order);
		repository.save(restaurent);
		return order;
	}
	
	public List<Restaurent> getAll() {
		return repository.findAll();
	}
	
	public void updateRestaurent(String name, String pincode) {
		Restaurent restaurent = repository.findByName(name);
		restaurent.setPincode(pincode);
		repository.save(restaurent);
	}
}
