package com.backend.entities.dto;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.backend.entities.Comment;
import com.backend.entities.Post;

public class CommentDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String text;
	private Instant instant;
	
	private PostDto post;
	public CommentDto() {
		
	}
	public CommentDto(Comment obj) {
		id = obj.getId();
		text = obj.getText();
		instant = obj.getDate();
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Instant getInstant() {
		return instant;
	}
	public void setInstant(Instant instant) {
		this.instant = instant;
	}
	public PostDto getPost() {
		return post;
	}
	public void setPost(PostDto post) {
		this.post = post;
	}
	
	
}
