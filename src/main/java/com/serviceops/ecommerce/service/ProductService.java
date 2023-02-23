package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;

import java.util.List;

public interface ProductService {
    public boolean createProduct(ProductDto product);
    public ProductDto updateProduct(ProductDto product);
    public boolean removeProduct(Long Id);
    public ProductDto findProductById(Long Id);
    public List<ProductDto> getAllProducts();
    public SubCategoryDto findProductSubCategory(Long Id);

    public void deleteByproductSubCategory(Long Id);




}
