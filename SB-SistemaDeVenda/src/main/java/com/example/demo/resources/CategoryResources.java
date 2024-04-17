package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResources {
	@Autowired
	private CategoryService services;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> categories = services.findAll();
		return ResponseEntity.ok().body(categories);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Integer id){
		Category category = services.findById(id);
		return ResponseEntity.ok().body(category);
	}
	
	@PostMapping
	public ResponseEntity<String> save(@RequestBody Category category){
		services.save(category);
		return new ResponseEntity<>("funcionou", HttpStatus.CREATED);
	}
}