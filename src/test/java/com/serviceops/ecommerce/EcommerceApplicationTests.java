package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.ProductRepository;
import com.serviceops.ecommerce.repository.ReviewRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.OrderItemService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EcommerceApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository	categoryRepository;
	@Autowired
	private UserRepository userRepository;


	@Test
	void contextLoads() {
//		reviewRepository.save(new Review(Ratings.THREE,productRepository.save(new Product("a","b",12,categoryRepository.save(new Category("HAircare")))),userRepository.save(new User("test1","as","test1","1234", Role.ADMIN))));
	}

}
