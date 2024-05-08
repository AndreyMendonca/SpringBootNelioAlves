package com.sistemaPost.entities.DTO;

import java.time.LocalDateTime;

import com.sistemaPost.entities.Comment;

import lombok.Data;

@Data
public class CommentDTO {
	private String text;
	private LocalDateTime date; 
	private String author;
	
	public CommentDTO(Comment comment) {
		this.text = comment.getText();
		this.date = comment.getDate();
		this.author = comment.getAuthor().getName();
	}
}
