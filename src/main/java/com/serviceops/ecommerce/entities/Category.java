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
    @OneToMany(mappedBy ="category",cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<SubCategory> subCategorySet = new HashSet<>();
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

    public Set<SubCategory> getSubCategoriesSet() {
        return subCategorySet;
    }
    public void setSubCategoriesSet(Set<SubCategory> subCategorySet) {
        this.subCategorySet = subCategorySet;
    }


}
