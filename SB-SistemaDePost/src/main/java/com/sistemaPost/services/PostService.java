package com.sistemaPost.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.Post;
import com.sistemaPost.entities.User;
import com.sistemaPost.repositories.PostRepository;
import com.sistemaPost.repositories.UserRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	
	@Autowired
	private UserRepository userRepository;
	
	/*
	@Autowired
	private UserRepository userRepository; */
	
	public Post findById(Integer id) {
		Optional<Post> post = repository.findById(id);
		return post.get();
	}
	
	public Post save(Post post) {
		Optional<User> author = userRepository.findById(post.getAuthor().getId());
		
		Post newPost = new Post(post.getTitle(), post.getBody(), author.get());
		
		return repository.save(newPost);
	}
	
}
