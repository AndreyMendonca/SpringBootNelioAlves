package com.sistemaPost.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sistemaPost.entities.Post;
import com.sistemaPost.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Post> findById(@PathVariable Integer id){
			Post post = service.findById(id);
			return ResponseEntity.ok().body(post);
	}
	
	@PostMapping
	public ResponseEntity<Post> save(@RequestBody Post post){
		post = service.save(post);
		return ResponseEntity.ok().body(post);
	}
}
