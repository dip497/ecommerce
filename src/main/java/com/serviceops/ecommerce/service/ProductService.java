package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;

import java.util.List;

public interface ProductService {
    public boolean createProduct(Product product);
    public Product updateProduct(Product product);
    public void removeProduct(Long Id);
    public Product findProductById(Long Id);
    public List<Product> getAllProducts();
    public SubCategory findProductSubCategory(Long Id);




}
