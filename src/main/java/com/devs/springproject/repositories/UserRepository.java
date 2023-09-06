package com.devs.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.springproject.entities.User;



public interface UserRepository extends JpaRepository<User, Long> {

}
