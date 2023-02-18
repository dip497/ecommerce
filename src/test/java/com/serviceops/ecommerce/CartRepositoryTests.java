package com.serviceops.ecommerce;


import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class CartRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderProductRepository orderProductRepository;

	@Autowired
	private CartRepository repo;
	@Test
	@Transactional
	void addProductToCart() {
		Optional<Category> category = categoryRepository.findById(6L);
		Optional<Product> byId = productRepository.findById(4L);
		Optional<Product> byId1 = productRepository.findById(5L);
		Optional<Product> byId2 = productRepository.findById(6L);
//		List<Product> products = new ArrayList<>();


//		Product product = new Product("1","pqe",111,category);
//		productRepository.save(product);
//		Product product1 = new Product("2","abc",121,category);
//		productRepository.save(product1);
//		Product product2 = new Product("3","jdc",131,category);
//		productRepository.save(product2);
//		Product product3 = new Product("4","off",141,category);
//		productRepository.save(product3);

//		products.add(product);
//		products.add(product1);
//		products.add(product2);
//		products.add(product3);



		List<OrderProduct> orderProducts = new ArrayList<>();

		OrderProduct orderProduct = orderProductRepository.save(new OrderProduct(byId.get(),12));
		OrderProduct orderProduct1 = orderProductRepository.save(new OrderProduct(byId1.get(),32));
//		orderProductRepository.save(orderProduct1);
		OrderProduct orderProduct2 = orderProductRepository.save(new OrderProduct(byId2.get(),5));
//		orderProductRepository.save(orderProduct2);
//		OrderProduct orderProduct3 = orderProductRepository.save(new OrderProduct(product3,9));
//		orderProductRepository.save(orderProduct3);

		orderProducts.add(orderProduct);
		orderProducts.add(orderProduct1);
		orderProducts.add(orderProduct2);
//		orderProducts.add(orderProduct3);


//		Cart cart = new Cart(orderProduct);

		User user = new User("dipendra","d","as",Role.ADMIN);
		logger.info("cart -> {}", repo.save(new Cart(orderProducts,user)));

	}

	@Test
	void testOrderProduct(){

		Category category = new Category("llo");
		categoryRepository.save(category);
		Product product = new Product("1","1",1,category);
		productRepository.save(product);
		OrderProduct orderProduct = orderProductRepository.save(new OrderProduct(product,4));
		logger.info("orderProduct -> {}",orderProduct);
	}

}
