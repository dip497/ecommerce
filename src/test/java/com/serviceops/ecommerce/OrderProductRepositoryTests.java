package com.serviceops.ecommerce;


import com.serviceops.ecommerce.entities.Cart;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.OrderProduct;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.repository.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OrderProductRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;



	@Autowired
	OrderProductRepository orderProductRepository;



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
