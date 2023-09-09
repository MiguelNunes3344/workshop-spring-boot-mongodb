package com.devs.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.springproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
