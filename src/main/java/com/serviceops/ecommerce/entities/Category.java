package com.serviceops.ecommerce.entities;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;


    private String categoryName;

    @OneToMany(mappedBy = "Product")
    private List<Product> productList;

    public Category(Long category_id, String category_name) {
        this.categoryId = category_id;
        this.categoryName = category_name;
    }

    public Long getCategory_id() {
        return categoryId;
    }

    public void setCategory_id(Long category_id) {
        this.categoryId = category_id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }


}
