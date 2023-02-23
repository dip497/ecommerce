package com.serviceops.ecommerce;


import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import com.serviceops.ecommerce.service.CartService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.SubCategoryService;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProductRepositoryTests {

	@Autowired
	private ProductService productService;
	@Autowired
	private SubCategoryService subCategoryService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void contextLoads()
	{
		System.out.println(productService.removeProduct(5L));
	}




}
