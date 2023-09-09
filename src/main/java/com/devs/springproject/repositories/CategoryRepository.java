package com.devs.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.springproject.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {

}
