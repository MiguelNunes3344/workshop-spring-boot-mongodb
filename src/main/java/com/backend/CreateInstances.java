package com.backend;


import java.time.Instant;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.backend.entities.Comment;
import com.backend.entities.Post;
import com.backend.entities.User;
import com.backend.entities.dto.AuthorDto;
import com.backend.repositories.CommentRepository;
import com.backend.repositories.PostRepository;
import com.backend.repositories.UserRepository;
import com.backend.entities.dto.CommentDto;

@Component
public class CreateInstances implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	@Override
	public void run(String... args) throws Exception {
		
		commentRepository.deleteAll();
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		var u = new User(null,"Michael","Michael@gmial.com");
		userRepository.save(u);
		var p = new Post(null,Instant.now(),"I'm Going Vacation","Hello everybody",new AuthorDto(u));
		postRepository.save(p);
		
		var comment = new Comment(null,"Good Trip",Instant.now(),p,u);
		var comment2 = new Comment(null,"Good luck",Instant.now(),p,u);
		commentRepository.saveAll(Arrays.asList(comment,comment2));
		
		
		
		u.getPosts().add(p);
		
		userRepository.saveAll(Arrays.asList(u));
		
		p.getComments().add(new CommentDto(comment));
		postRepository.save(p);
		
	}

}
