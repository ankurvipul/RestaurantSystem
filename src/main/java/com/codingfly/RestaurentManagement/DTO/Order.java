package com.codingfly.RestaurentManagement.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {
	
	@Id
	int id;
	String restaurentName;
	int quantity;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRestaurentName() {
		return restaurentName;
	}
	public void setRestaurentName(String restaurentName) {
		this.restaurentName = restaurentName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
