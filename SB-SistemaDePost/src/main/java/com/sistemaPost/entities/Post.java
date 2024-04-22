package com.sistemaPost.entities;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tb_post")
@NoArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private LocalDate datePost;
	private String body;
	
	@ManyToOne()
	private User Author;
	
	public Post(String title, String body, User Author) {
		this.title = title;
		this.body = body;
		this.Author = Author;
		this.datePost = LocalDate.now();
	}
}
