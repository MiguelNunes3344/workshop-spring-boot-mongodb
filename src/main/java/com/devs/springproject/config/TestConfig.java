package com.devs.springproject.config;

import java.time.Instant;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devs.springproject.entities.Category;
import com.devs.springproject.repositories.CategoryRepository;
import com.devs.springproject.entities.Order;
import com.devs.springproject.entities.User;
import com.devs.springproject.entities.enums.OrderStatus;
import com.devs.springproject.repositories.OrderRepository;
import com.devs.springproject.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Anna Montana", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Montano", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		
		Order o1 = new Order(null, Instant.parse("2000-10-10T19:30:05Z"),OrderStatus.PAID,u1);
		Order o2 = new Order(null, Instant.parse("1995-10-15T20:30:05Z"),OrderStatus.SHIPPED,u2);
		
		orderRepository.saveAll(Arrays.asList(o1,o2));
		
		Category c1 = new Category(null,"Eletronics");
		Category c2 = new Category(null,"Foods");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2));
		
		
		
	} 
	
	
}
