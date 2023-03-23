package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Product extends Audit{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;

    private String productDesc;
    private int productPrice;
    @OneToMany(mappedBy = "product",cascade = CascadeType.REMOVE)
    private List<Review> reviews;



    @ManyToOne
    private Category productCategory;

    protected Product(){

    }
    public Product(String productName, String productDesc, int productPrice, Category productCategory) {
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
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

    public Category getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
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
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productCategory=" + productCategory +
                ", productCreatedBy=" + super.getCreatedBy()+
                ", productUpdatedBy=" + super.getUpdatedBy()+
                '}';
    }
}
