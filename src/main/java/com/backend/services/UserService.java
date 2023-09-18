package com.backend.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.entities.User;
import com.backend.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	public Optional<User> findById(String id) {
		return repository.findById(id);
	}
	public void insert(User u) {
		repository.save(u);
	}
	public void delete(String id) {
		repository.deleteById(id);
	}
	public void update(String id, User u) {
		Optional<User> updated = repository.findById(id);
		BeanUtils.copyProperties(u, updated.get(),"id");
		repository.save(updated.get());
	}
}
