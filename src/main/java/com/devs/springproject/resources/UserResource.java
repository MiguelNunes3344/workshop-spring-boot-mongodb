package com.devs.springproject.resources;

import java.net.URI;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devs.springproject.entities.User;
import com.devs.springproject.services.UserService;

import jakarta.servlet.Servlet;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@Autowired
	private UserService userService;
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> list = userService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		User user = userService.findById(id);
		return ResponseEntity.ok().body(user);
	}
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User user) {
		userService.insert(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(user);
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable(value = "id")Long id, @RequestBody User user) {
		userService.update(id,user);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@DeleteMapping(value = "{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id")Long id){
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@GetMapping(value = "/index")
	public ModelAndView index() {
		var m = new ModelAndView("index");
		return m;
	}
 	
}
