package com.serviceops.ecommerce.entities;


import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;


@Entity
public class SubCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subcategoryId;

    private String subcategoryName;

    @OneToMany(mappedBy = "productSubCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Product> productSet = new HashSet<>();
    @ManyToOne(fetch = FetchType.EAGER)
    private Category category;

    protected SubCategory(){

    }

    public SubCategory(String subcategoryName, Category category) {
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

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }
    public SubCategory(Category category) {
        this.category = category;
    }
    public Category getCategory() {
        return  category;
    }

  






}
