package com.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entities.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
