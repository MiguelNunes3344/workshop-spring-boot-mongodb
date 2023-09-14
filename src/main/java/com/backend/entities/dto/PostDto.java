package com.backend.entities.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;

import com.backend.entities.Post;

public class PostDto implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Instant date;
	private String title;
	private String body;
	private AuthorDto author;
	
	public PostDto() {
		
	}
	public PostDto(Post obj) {
		id = obj.getId();
		date = obj.getInstant();
		title = obj.getTitle();
		body = obj.getBody();
		author = obj.getAuthor();
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public AuthorDto getAuthor() {
		return author;
	}
	public void setAuthor(AuthorDto author) {
		this.author = author;
	}
}
