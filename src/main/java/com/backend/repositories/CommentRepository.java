package com.backend.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.backend.entities.Comment;
import com.backend.entities.dto.CommentDto;

public interface CommentRepository extends MongoRepository<Comment, String> {
	
		@Query("{ 'text': { $regex: ?0, $options: 'i' } }")
		List<CommentDto> searchByTitle(String text);

		List<CommentDto> findByTextContainingIgnoreCase(String text);
}
