package com.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.Post;
import com.backend.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	public PostRepository repository;
	
	public List<Post> findAll() {
		return repository.findAll();
	}
	
	public Optional<Post> findById(String id) {
		return repository.findById(id);
	}
}
