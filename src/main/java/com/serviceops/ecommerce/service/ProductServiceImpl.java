package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;

import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.ProductRepository;

import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean createProduct(ProductDto product) {
        Product product1 = new Product(product.getProductName(), product.getProductDesc(), product.getProductPrice(), categoryRepository.findById(product.getProductCategory().getCategoryId()).get());
        product1.setCreatedBy(product.getCreatedBy());
        productRepository.save(product1);
        logger.info("Product Created");
        return true;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        Product product1 = productRepository.findById(product.getProductId()).get();
        product1.setProductDesc(product.getProductDesc());
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setUpdatedBy(product.getUpdatedBy());
        productRepository.save(product1);
        logger.info("Updated Product ->",product1);
        return product;
    }
//    public void deleteByproductSubCategory(Long Id){
//        productRepository.deleteByproductSubCategory(Id);
//    }

    @Override
    public boolean removeProduct(Long Id) {
        productRepository.deleteById(Id);
        logger.info("Deleted Product Id"+ Id);
        return true;
    }

    @Override
    public ProductDto findProductById(Long Id) {

        Product product = productRepository.findById(Id).get();
        ProductDto productDto = Helper.EntityToDto(product);
        productDto.setProductId(product.getProductId());
        logger.info("Product Found ->{}",product);
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        logger.info("All Products List ->{}",products);
        return products.stream().map(products1 -> Helper.EntityToDto(products1)).collect(Collectors.toList());

    }

    @Override
    public CategoryDto findProductCategory(Long Id) {
        logger.info("Product SubCategory"+Id);
        return Helper.EntityToDto(categoryRepository.findById(Id).get());
    }

    @Override
    public List<ProductDto> findByProductCategory(CategoryDto category) {
        logger.info("Find List of Products Acc tp Category ->{}",category);
        return productRepository.findByProductCategory(categoryRepository.findById(category.getCategoryId()).get()).stream().map(
                product -> Helper.EntityToDto(product)).collect(Collectors.toList());

    }


}