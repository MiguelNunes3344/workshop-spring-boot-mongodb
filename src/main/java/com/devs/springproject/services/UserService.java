package com.devs.springproject.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.devs.springproject.entities.User;
import com.devs.springproject.repositories.UserRepository;
import com.devs.springproject.resources.exceptions.DatabaseException;
import com.devs.springproject.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	public void insert(User user) {
		repository.save(user);
	}
	public void update(Long id,User user) {
		try {
			Optional<User> obj = repository.findById(id);
			BeanUtils.copyProperties(user, obj.get(),"id");
			repository.save(obj.get());
		} catch (NoSuchElementException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		} catch (DatabaseException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
}
