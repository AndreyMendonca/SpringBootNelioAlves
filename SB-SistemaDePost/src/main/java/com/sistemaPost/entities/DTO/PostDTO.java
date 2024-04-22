package com.sistemaPost.entities.DTO;

import java.io.Serializable;
import java.time.LocalDate;

import com.sistemaPost.entities.Post;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PostDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String title;
	private LocalDate datePost;
	private String body;
	
	public PostDTO(Post post) {
		this.title = post.getTitle();
		this.datePost = post.getDatePost();
		this.body = post.getBody();
	}
}
