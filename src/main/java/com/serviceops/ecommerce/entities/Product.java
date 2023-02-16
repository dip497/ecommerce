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


    @OneToMany(mappedBy = "Review")
    private List<Review> reviews;
    @ManyToOne
    private  Category productCategory;

    public Product(String product_name, String product_desc, int product_price, Category product_category) {
        this.productName = product_name;
        this.productDesc = product_desc;
        this.productPrice = product_price;
        this.productCategory = product_category;
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

    public Category getproduct_category() {
        return productCategory;
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
                ", product_category=" + productCategory +
                '}';
    }


}
