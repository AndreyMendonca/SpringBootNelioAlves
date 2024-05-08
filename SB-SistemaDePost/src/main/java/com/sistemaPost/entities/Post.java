package com.sistemaPost.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@JoinColumn(name="id_author")
	private User author;
	
	@OneToMany(mappedBy="post", cascade = CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	public Post(String title, String body, User author) {
		this.title = title;
		this.body = body;
		this.author = author;
		this.datePost = LocalDate.now();
	}
}
