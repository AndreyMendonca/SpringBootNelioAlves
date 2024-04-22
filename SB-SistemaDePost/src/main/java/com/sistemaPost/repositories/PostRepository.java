package com.sistemaPost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaPost.entities.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{

}
