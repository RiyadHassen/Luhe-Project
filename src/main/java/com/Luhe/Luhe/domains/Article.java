package com.Luhe.Luhe.domains;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.Luhe.Luhe.security.User;

import lombok.Data;

@Data
@Entity
@Table(name="article" ,schema="luhe")
public class Article {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message="Title can't be empty")
	@NotNull
	@Size(min=5, message="Title must be at least 5 characters long")
	private String title;
	
	@NotBlank(message="Content can't be empty")
	@NotNull
	@Size(min=10, message="Content must be at least 10 characters long")
	@Lob
	private String content;
	
	

	@ManyToOne 
	private Catagory catagory;
	
	@Column(columnDefinition="int default 0")
	private int likeRate;
	
	@Column(columnDefinition="int default 0")
	private int dislikeRate;
	
	private Date createdAt;
	
	
	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
		this.approval="false";
	}	 
	
	
	private String  approval;
	
	@ManyToOne
	private  User user;
}