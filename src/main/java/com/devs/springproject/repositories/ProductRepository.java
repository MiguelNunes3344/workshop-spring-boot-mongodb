package com.devs.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.springproject.entities.Category;
import com.devs.springproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {

}
