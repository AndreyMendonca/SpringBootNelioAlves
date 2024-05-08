package com.sistemaPost.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemaPost.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}
