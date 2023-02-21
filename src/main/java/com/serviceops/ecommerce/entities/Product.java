package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;

    private String productDesc;
    private int productPrice;
    @OneToMany(mappedBy = "product" )
    private List<Review> reviews;
    @ManyToOne
    private SubCategory productSubCategory;

    protected Product(){

    }
    public Product(String productName, String productDesc, int productPrice, SubCategory productSubCategory) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productSubCategory = productSubCategory;
    }

    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public SubCategory getProductCategory() {
        return productSubCategory;
    }


    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }


    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + productName + '\'' +
                ", product_desc='" + productDesc + '\'' +
                ", product_price=" + productPrice +
                ", product_subcategory=" + productSubCategory +
                '}';
    }


}
