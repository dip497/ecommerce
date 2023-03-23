package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;

import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.CustomRepository;
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

    @Autowired
    CustomRepository customRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public boolean createProduct(ProductDto product) {
        Product product1 = new Product(product.getProductName(), product.getProductDesc(), product.getProductPrice(),
                customRepository.findByColumn("categoryId",String.valueOf(product.getProductCategory().getCategoryId()),Category.class));
             //   categoryRepository.findById(product.getProductCategory().getCategoryId()).get());
        product1.setCreatedBy(product.getCreatedBy());
        customRepository.save(product1);
      //  productRepository.save(product1);
        logger.info("Product Created");
        return true;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        Product product1 = customRepository.findByColumn("productId",String.valueOf(product.getProductId()),Product.class);
         //       productRepository.findById(product.getProductId()).get();
        product1.setProductDesc(product.getProductDesc());
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setUpdatedBy(product.getUpdatedBy());
        customRepository.save(product1);
      //  productRepository.save(product1);
        logger.info("Updated Product ->",product1);
        return product;
    }
//    public void deleteByproductSubCategory(Long Id){
//        productRepository.deleteByproductSubCategory(Id);
//    }

    @Override
    public boolean removeProduct(Long Id) {
        customRepository.deleteById(Product.class,Id,"productId");
    //    productRepository.deleteById(Id);
        logger.info("Deleted Product Id"+ Id);
        return true;
    }

    @Override
    public ProductDto findProductById(Long Id) {

        Product product = customRepository.findByColumn("productId",String.valueOf(Id),Product.class);
             //   productRepository.findById(Id).get();
        ProductDto productDto = Helper.EntityToDto(product);
        productDto.setProductId(product.getProductId());
        logger.info("Product Found ->{}",product);
        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = customRepository.findAll(Product.class);
             //   productRepository.findAll();
        logger.info("All Products List ->{}",products);
        return products.stream().map(Helper::EntityToDto).toList();

    }

    @Override
    public CategoryDto findProductCategory(Long Id) {
        logger.info("Product SubCategory"+Id);
        return Helper.EntityToDto(customRepository.findByColumn("categoryId",String.valueOf(Id),Category.class));
    }

    @Override
    public List<ProductDto> findByProductCategory(CategoryDto category) {
        logger.info("Find List of Products Acc tp Category ->{}",category);
        return productRepository.findByProductCategory(categoryRepository.findById(category.getCategoryId()).get()).stream().map(
                product -> Helper.EntityToDto(product)).collect(Collectors.toList());

    }


}