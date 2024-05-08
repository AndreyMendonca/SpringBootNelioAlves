package com.sistemaPost.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaPost.entities.Comment;
import com.sistemaPost.entities.Post;
import com.sistemaPost.entities.User;
import com.sistemaPost.repositories.CommentRepository;
import com.sistemaPost.repositories.PostRepository;
import com.sistemaPost.repositories.UserRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Comment save(Comment comment) {
		Optional<Post> post = postRepository.findById(comment.getPost().getId());
		
		Optional<User> user = userRepository.findById(comment.getAuthor().getId());
		
		Comment newComment =  new Comment(comment.getText(), post.get(), user.get());
		
		post.get().getComments().add(newComment);
		
		return repository.save(newComment);
	}
}
