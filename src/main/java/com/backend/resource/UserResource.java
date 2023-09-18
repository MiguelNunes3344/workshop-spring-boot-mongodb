package com.backend.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.backend.entities.Post;
import com.backend.entities.User;
import com.backend.entities.dto.UserDto;
import com.backend.repositories.UserRepository;
import com.backend.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<User> list = userService.findAll();
		List<UserDto> listDto = list.stream().map(x -> new UserDto(x)).toList();
		return ResponseEntity.ok(listDto);
	}
	@GetMapping(value = "/{id}/posts")
	public ResponseEntity<List<Post>> findById(@PathVariable(value = "id") String id) {
		Optional<User> user = userService.findById(id);
		return ResponseEntity.ok(user.get().getPosts());
	}
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User u) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		userService.insert(u);
		return ResponseEntity.created(uri).body(u);
	}
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> delete(@PathVariable(value = "id") String id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable(value = "id") String id, @RequestBody User u) {
		userService.update(id, u);
		return ResponseEntity.ok(u);
	}
	
}
