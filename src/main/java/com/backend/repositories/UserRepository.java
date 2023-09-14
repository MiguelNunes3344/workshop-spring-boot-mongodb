package com.backend.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.backend.entities.User;


public interface UserRepository extends MongoRepository<User,String> {

}
