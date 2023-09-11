package com.devs.springproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devs.springproject.entities.OrderItem;




public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
