package com.serviceops.ecommerce.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Review {

    @Id
    private Long reviewId;
    private User user;

    @OneToMany
    private Product product;
    private Enum ratings;

    public Review(User user, Product product, Enum ratings) {
        this.user = user;
        this.product = product;
        this.ratings = ratings;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Enum getRatings() {
        return ratings;
    }

    public void setRatings(Enum ratings) {
        this.ratings = ratings;
    }
}
