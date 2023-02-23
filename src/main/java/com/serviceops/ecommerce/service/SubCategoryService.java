package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.SubCategory;

import java.util.List;
import java.util.Set;

public interface SubCategoryService {

    public boolean createSubCategory(SubCategoryDto subCategory);
    public List<SubCategoryDto> getAllSubCategroies();
    public void removeSubCategoryById(Long Id);
    public SubCategoryDto findSubCategoryById(Long Id);
    public SubCategoryDto updateSubCategoryById(SubCategoryDto subCategory);




}