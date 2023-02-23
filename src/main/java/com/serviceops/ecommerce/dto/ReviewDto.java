package com.serviceops.ecommerce.dto;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Ratings;
import com.serviceops.ecommerce.entities.Review;

import java.io.Serializable;


public class ReviewDto   {
    private  Long reviewId;

    private String description;
    private  Ratings ratings;
    private  ProductDto product;
    private  UserDto user;

    public ReviewDto() {
    }

    public ReviewDto(Long reviewId, String description,Ratings ratings, ProductDto product, UserDto user) {

        this.reviewId = reviewId;
        this.description=description;
        this.ratings = ratings;
        this.product = product;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public Ratings getRatings() {
        return ratings;
    }

    public ProductDto getProduct() {
        return product;
    }

    public UserDto getUser() {
        return user;
    }

    public void setProduct(ProductDto product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return "ReviewDto{" +
                "reviewId=" + reviewId +
                ", description='" + description + '\'' +
                ", ratings=" + ratings +
                ", product=" + product +
                ", user=" + user +
                '}';
    }
}