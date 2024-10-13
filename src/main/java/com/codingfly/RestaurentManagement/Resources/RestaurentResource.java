package com.codingfly.RestaurentManagement.Resources;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingfly.RestaurentManagement.DTO.Order;
import com.codingfly.RestaurentManagement.DTO.Restaurent;
import com.codingfly.RestaurentManagement.DTO.Review;
import com.codingfly.RestaurentManagement.Service.RestaurentService;

@RestController
public class RestaurentResource {
	
	@Autowired
	private RestaurentService service;
	
	@PostMapping(path="/restaurent/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody Restaurent restaurent) {
		Restaurent restaurent2 = service.register(restaurent);
		if (restaurent2 == null) {
			return ResponseEntity.badRequest().body("Already exists");
		}
		
		return ResponseEntity.ok(restaurent2.toString());
	}
	
	@PutMapping(path="/review", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createReview(@RequestBody Review review) {
		service.addReview(review);
		return ResponseEntity.ok("Review added successfully");
	}
	
	@PostMapping(path="/restaurent/placeorder", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> placeOrder(@RequestBody Order order) {
		Order order2 = service.placeOrder(order);
		if (order2 == null) {
			return ResponseEntity.badRequest().body("Number of quantity is not available at given restaurent");
		}
		
		return ResponseEntity.ok(order2.toString());
	}
	
	@GetMapping(path="/restaurents/show", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> showRestaurents(String type) {
		List<Restaurent> restaurents = service.getAll();
		if (type.equals("Price")) {
			Collections.sort(restaurents, ((a,b) -> a.getItem().getPrize() - b.getItem().getPrize()));
		}
		else {
			Collections.sort(restaurents, ((a,b) -> b.getReviews().size() - a.getReviews().size()));
		}
		return ResponseEntity.ok(restaurents);
	}
	
	@PutMapping(path="/restaurents/update/{name}/{pincode}")
	public ResponseEntity<?> updateRestaurent(@RequestParam("name") String name, @RequestParam("pincode") String pincode) {
		service.updateRestaurent(name, pincode);
		return ResponseEntity.ok("Address updated");
	}
}
