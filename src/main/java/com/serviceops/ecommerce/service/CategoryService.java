package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;

import java.util.List;

public interface CategoryService {

    public boolean createCategory(Category category);
    public List<Category> getAllCategroies();
    public void removeCategoryById(Long Id);
    public Category findCategoryById(Long Id);
    public Category updateCategoryById(Category category);



}
