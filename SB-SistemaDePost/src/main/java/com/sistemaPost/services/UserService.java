package com.sistemaPost.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.User;
import com.sistemaPost.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Integer id) {
		Optional<User> user = repository.findById(id);
		return user.get();
	}
	
	public User save(User user) {
		user = repository.save(user);
		return user;
	}
	
	public User update(User user, Integer id) {
		User obj = repository.getReferenceById(id);
		updateData(obj, user);
		return obj;
	}
	
	public void updateData(User obj, User user) {
		obj.setName(user.getName());
		obj.setEmail(user.getEmail());
	}
}
