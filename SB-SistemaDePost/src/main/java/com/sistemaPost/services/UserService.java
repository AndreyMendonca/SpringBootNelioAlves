package com.sistemaPost.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.User;
import com.sistemaPost.entities.DTO.UserDTO;
import com.sistemaPost.repositories.UserRepository;
import com.sistemaPost.services.exceptions.ObjectNotFoundException;

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
		try {
			Optional<User> user = repository.findById(id);
			UserDTO dto = new UserDTO(user.get().getName(), user.get().getEmail());
			return dto;
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Cliente nao encontrado");
		}
		
	}
	
	public User save(User user) {
		user = repository.save(user);
		return user;
	}
	
	public void delete(Integer id) {
		try {
			Optional<User> user = repository.findById(id);
			repository.delete(user.get());
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Cliente nao encontrado");
		}
		
		
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
