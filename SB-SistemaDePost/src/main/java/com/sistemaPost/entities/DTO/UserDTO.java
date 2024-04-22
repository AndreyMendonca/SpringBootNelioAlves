package com.sistemaPost.entities.DTO;

import java.util.ArrayList;
import java.util.List;

import com.sistemaPost.entities.Post;
import com.sistemaPost.entities.User;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class UserDTO {
	private String name;
	private String email;
	
	private List<PostDTO> posts = new ArrayList<>();
	
	public UserDTO(User user) {
		this.name = user.getName();
		this.email = user.getEmail();
		for(Post p : user.getPosts()) {
			posts.add(new PostDTO(p));
		}
	}
	
}
