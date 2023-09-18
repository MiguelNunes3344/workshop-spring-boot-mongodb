package com.backend.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.entities.Comment;
import com.backend.entities.dto.CommentDto;
import com.backend.resource.utils.DecodeUri;
import com.backend.services.CommentService;

@RestController
@RequestMapping(value = "/comments")
public class CommentResource {

	@Autowired
	private CommentService commentService;
	
	@GetMapping
	public ResponseEntity<List<Comment>> findAll() {
		List<Comment>list =commentService.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<CommentDto>> findByTitle(@RequestParam(value = "text") String text) {
		text = DecodeUri.urlDecode(text);
		List<CommentDto> list = commentService.findTitle(text);
		return ResponseEntity.ok().body(list);
	}
	
}
