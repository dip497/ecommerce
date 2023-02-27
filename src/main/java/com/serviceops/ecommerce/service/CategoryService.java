package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;

import com.serviceops.ecommerce.entities.Category;


import java.util.List;
import java.util.Set;

public interface CategoryService {

    public boolean createCategory(CategoryDto categoryDto);
    public List<CategoryDto> getAllCategroies();
    public void removeCategoryById(Long Id);
    public CategoryDto findCategoryById(Long Id);
    public CategoryDto updateCategoryById(CategoryDto CategoryDto);
    public List<CategoryDto> getAllSubCategoryById(Long Id);
    public List<CategoryDto> getSubcategories(String categoryName);



}