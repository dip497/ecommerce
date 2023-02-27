package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.ReviewDto;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;


import java.util.List;

public interface ProductService {
     boolean createProduct(ProductDto product);
     ProductDto updateProduct(ProductDto product);
     boolean removeProduct(Long Id);
     ProductDto findProductById(Long Id);
     List<ProductDto> getAllProducts();
     CategoryDto findProductCategory(Long Id);
     List<ProductDto> findByProductCategory(CategoryDto category);
//    public void deleteByproductSubCategory(Long Id);




}