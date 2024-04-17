package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Order;
import com.example.demo.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		List<Order> orders = repository.findAll();
		return orders;
	}

	public Order findById(Integer id) {
		Optional<Order> order = repository.findById(id);
		return order.get();
	}
}
