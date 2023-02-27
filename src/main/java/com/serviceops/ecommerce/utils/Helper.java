package com.serviceops.ecommerce.utils;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.Role;

public class Helper {
    private Helper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static Role getRole(String role) {
        if (role.equals(Role.CUSTOMER.toString())) {
            return Role.CUSTOMER;
        } else {
            return Role.ADMIN;
        }
    }
    public static CategoryDto EntityToDto(Category category)
    {
        CategoryDto categoryDto = new CategoryDto(category.getCategoryId(), category.getCategoryName());
        categoryDto.setCreatedBy(category.getCreatedBy());
        categoryDto.setUpdatedBy(category.getUpdatedBy());
        return categoryDto;
    }
    public static ProductDto EntityToDto(Product product){
        ProductDto productDto = new ProductDto(product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), EntityToDto(product.getProductCategory()));
        productDto.setCreatedBy(product.getCreatedBy());
        productDto.setUpdatedBy(product.getUpdatedBy());
        return productDto;
    }

}
