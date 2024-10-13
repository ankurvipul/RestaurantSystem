package com.codingfly.RestaurentManagement.Resources;


import javax.swing.text.AbstractDocument.Content;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codingfly.RestaurentManagement.DTO.User;
import com.codingfly.RestaurentManagement.Service.UserService;

@RestController
public class UserResource {
	
	@Autowired
	UserService service;
	
	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@RequestBody User user) {
		User user1 = service.register(user);
		if (user1 == null) {
			return ResponseEntity.badRequest().body("User with email id " + user1.getName() + " already exists");
		}
		
		return ResponseEntity.ok(user1.toString());
	}
	
	@GetMapping(path = "/login/{name}/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> register(@PathVariable("name") String name, @PathVariable("phone") String phone) {
		User user1 = service.login(name, phone);
		if (user1 == null) {
			return ResponseEntity.badRequest().body("User with email id " + user1.getName() + " already exists");
		}
		
		return ResponseEntity.ok(user1.toString());
	}
}
