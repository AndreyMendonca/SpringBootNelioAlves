package com.sistemaPost.entities.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sistemaPost.entities.Post;

import lombok.Data;

@Data
public class PostAuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private LocalDate datePost;
	private String body;
	private String author;
	
	private List<CommentDTO> comments = new ArrayList<>();
	
	public PostAuthorDTO(Post post) {
		this.title = post.getTitle();
		this.datePost = post.getDatePost();
		this.body = post.getBody();
		this.author = post.getAuthor().getName();
	}
	
	public void addComments(CommentDTO dto) {
		comments.add(dto);
	}
}
