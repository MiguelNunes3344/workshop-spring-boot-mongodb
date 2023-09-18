package com.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.Comment;
import com.backend.entities.dto.CommentDto;
import com.backend.repositories.CommentRepository;

@Service
public class CommentService {

	
	@Autowired
	private CommentRepository commentRepository;
	
	
	public List<Comment> findAll() {
		return commentRepository.findAll();
	}
	public List<CommentDto> findTitle(String text) {
		return commentRepository.searchByTitle(text);
	}
}
