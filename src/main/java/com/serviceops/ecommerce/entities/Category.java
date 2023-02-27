package com.serviceops.ecommerce.entities;


import jakarta.persistence.*;


import java.util.ArrayList;

import java.util.List;
import java.util.function.Supplier;

@Entity
public class Category extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    private String categoryName;
    @ManyToOne
    private Category parent;
    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Category> subcategories = new ArrayList<>();
    @OneToMany(mappedBy = "productCategory",cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Product> products = new ArrayList<>();
    protected Category(){


    }
    public Category(String categoryName,Category parent){
        this.categoryName = categoryName;
        this.parent = parent;
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

    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    public List<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Category> subcateories) {
        this.subcategories = subcategories;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(Product product) {
        products.add(product);
    }
    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", parent=" + parent +
                '}';
    }



}
