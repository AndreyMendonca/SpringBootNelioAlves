package com.sistemaPost.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.Post;
import com.sistemaPost.entities.User;
import com.sistemaPost.entities.DTO.PostAuthorDTO;
import com.sistemaPost.repositories.PostRepository;
import com.sistemaPost.repositories.UserRepository;
import com.sistemaPost.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;
	@Autowired
	private UserRepository userRepository;
	
	public PostAuthorDTO findById(Integer id) {
		try {
			Optional<Post> post = repository.findById(id);
			PostAuthorDTO dto = new PostAuthorDTO(post.get());
			return dto;
		}catch(NoSuchElementException e) {
			throw new ObjectNotFoundException("Post não encontrado");
		}
	}
	
	public List<PostAuthorDTO> findAll(){
		List<Post> posts =  repository.findAll();
		List<PostAuthorDTO> postsDTOS = posts.stream().map(x -> new PostAuthorDTO(x)).collect(Collectors.toList());
		return postsDTOS;
	}
	
	public Post save(Post post) {
		Optional<User> author = userRepository.findById(post.getAuthor().getId());
		
		Post newPost = new Post(post.getTitle(), post.getBody(), author.get());
		
		return repository.save(newPost);
	}
}
