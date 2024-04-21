package com.sistemaPost.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.User;
import com.sistemaPost.entities.DTO.UserDTO;
import com.sistemaPost.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository repository;
	
	public List<UserDTO> findAll(){
		List<User> users = repository.findAll();
		List<UserDTO> usersDTO = users.stream().map( x -> new UserDTO(x.getName(),x.getEmail())).collect(Collectors.toList());
		return usersDTO;
	}
	
	public UserDTO findById(Integer id) {
		Optional<User> user = repository.findById(id);
		UserDTO dto = new UserDTO(user.get().getName(), user.get().getEmail());
		return dto;
	}
	
	public User save(User user) {
		user = repository.save(user);
		return user;
	}
	
	public User update(User user, Integer id) {
		User obj = repository.getReferenceById(id);
		updateData(obj, user);
		return repository.save(obj);
	}
	
	public void updateData(User obj, User user) {
		obj.setName(user.getName());
		obj.setEmail(user.getEmail());
	}
}
