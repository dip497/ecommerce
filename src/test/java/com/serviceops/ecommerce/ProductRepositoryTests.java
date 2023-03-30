package com.serviceops.ecommerce;


import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.ProductRepository;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.utils.Helper;
import org.hibernate.sql.results.graph.collection.internal.ListInitializerProducer;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class ProductRepositoryTests {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Test
	void contextLoads()
	{
		System.out.println(productService.removeProduct(5L));
	}

	void getSubcategory()
	{
		ProductDto productById = productService.findProductById(4L);
		System.out.println(productById );

	}

	@Test
	void deleteProductWithReview(){
		productService.removeProduct(9L);

	}

	@Test
	void addProduct()
	{
		productService.createProduct(new ProductDto("Apple","S23 Ultra",54000,categoryService.findCategoryById(1L)));
	}
	void  findProduct(){
		List<ProductDto> productDtoList = categoryService.findCategoryById(6l).getProductDtoList();
		System.out.println(productDtoList.get(0).getProductCategory().getCategoryId());


	}

	@Test
	void findProductByCat(){

		logger.info("Products ->{}",productRepository.findByProductCategory(categoryRepository.findById(1L).get()));
	}
	@Test
	void getProductId(){
		long productId = productRepository.findById(2l).get().getProductId();
		System.out.println(productId);
	}

	void getProduct(){
		ProductDto productById = productService.findProductById(3l);
		System.out.println(productById.getProductId());

	}


	void testEntityToDto(){
		Product product = productRepository.findById(5L).get();
		ProductDto productDto = Helper.EntityToDto(product);
		logger.info("Product ->{}",product);
		logger.info("Product Dto ->{}",productDto);

	}




}
