package com.serviceops.ecommerce.entities;


import jakarta.persistence.*;

import java.util.HashSet;

import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    @OneToMany(mappedBy ="category")
    private Set<SubCategories> subCategoriesSet = new HashSet<>();
    protected Category(){

    }
    public Category(String categoryName)
    {
        this.categoryName = categoryName;
    }
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<SubCategories> getSubCategoriesSet() {
        return subCategoriesSet;
    }
    public void setSubCategoriesSet(Set<SubCategories> subCategoriesSet) {
        this.subCategoriesSet = subCategoriesSet;
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", subCategoriesSet=" + subCategoriesSet +
                '}';
    }

}
