package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.SubCategory;

import java.util.List;

public interface SubCategoryService {

    public boolean createSubCategory(SubCategory subCategory);
    public List<SubCategory> getAllSubCategroies();
    public void removeSubCategoryById(Long Id);
    public SubCategory findSubCategoryById(Long Id);
    public SubCategory updateSubCategoryById(SubCategory subCategory);



}