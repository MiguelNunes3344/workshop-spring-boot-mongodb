package com.backend.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.backend.entities.dto.AuthorDto;
import com.backend.entities.dto.CommentDto;

@Document(collection = "post")
public class Post implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private Instant date;
	private String title;
	private String body;
	

	private AuthorDto author;
	
	List<CommentDto> comments = new ArrayList<>();
	
	public Post() {
		
	}
	

	public Post(String id, Instant date, String title, String body,AuthorDto author) {
		super();
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.author = author;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Instant getInstant() {
		return date;
	}


	public void setInstant(Instant date) {
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
	
	

	public List<CommentDto> getComments() {
		return comments;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
