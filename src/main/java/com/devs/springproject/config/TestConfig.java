package com.devs.springproject.config;

import java.time.Instant;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.devs.springproject.entities.Category;
import com.devs.springproject.repositories.CategoryRepository;
import com.devs.springproject.repositories.OrderItemRepository;
import com.devs.springproject.entities.Order;
import com.devs.springproject.entities.OrderItem;
import com.devs.springproject.entities.Product;
import com.devs.springproject.entities.User;
import com.devs.springproject.entities.enums.OrderStatus;
import com.devs.springproject.repositories.OrderRepository;
import com.devs.springproject.repositories.ProductRepository;
import com.devs.springproject.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
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
		Category c3 = new Category(null,"Books");
		
		categoryRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		p1.getCategories().add(c3);
		p2.getCategories().add(c1);
		p3.getCategories().add(c1);
		p4.getCategories().add(c1);
		p5.getCategories().add(c3);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p2, 1, p2.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o2, p4, 2, p4.getPrice()); 
		OrderItem oi5 = new OrderItem(o2, p5, 2, p5.getPrice()); 
		
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4,oi5));

		
	} 
	
	
}
