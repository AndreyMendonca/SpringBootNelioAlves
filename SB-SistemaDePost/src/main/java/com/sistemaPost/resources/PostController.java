package com.sistemaPost.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sistemaPost.entities.Post;
import com.sistemaPost.entities.DTO.PostAuthorDTO;
import com.sistemaPost.services.PostService;

@RestController
@RequestMapping("/posts")
public class PostController {
	
	@Autowired
	private PostService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<PostAuthorDTO> findById(@PathVariable Integer id){
			PostAuthorDTO post = service.findById(id);
			return ResponseEntity.ok().body(post);
	}
	
	@PostMapping
	public ResponseEntity<Void> save(@RequestBody Post post){
		post = service.save(post);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping()
	public ResponseEntity<List<PostAuthorDTO>> findAll(){
		List<PostAuthorDTO> posts = service.findAll();
		return ResponseEntity.ok().body(posts);
	}
}
