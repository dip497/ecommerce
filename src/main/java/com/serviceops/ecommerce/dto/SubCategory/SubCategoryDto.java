package com.serviceops.ecommerce.dto.SubCategory;


import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;

import java.util.HashSet;
import java.util.Set;

public class SubCategoryDto {

    private Long subcategoryId;


    private String subcategoryName;

    private Set<ProductDto> productSet = new HashSet<>();

    private CategoryDto category;

    public SubCategoryDto(){

    }

    public SubCategoryDto(Long subcategoryId,String subcategoryName, CategoryDto category) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
        this.category = category;


    }
    public Long getSubcategoryId() {
        return subcategoryId;
    }
    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Set<ProductDto> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<ProductDto> productSet) {
        this.productSet = productSet;
    }
    public void setCategory(CategoryDto category) {
        this.category = category;
    }
    public CategoryDto getCategory() {
        return  category;
    }
    @Override
    public String toString() {
        return "SubCategoryDto{" +
                "subcategoryId=" + subcategoryId +
                ", subcategoryName='" + subcategoryName + '\'' +
                ", productSet=" + productSet +
                ", category=" + category +
                '}';
    }






}
