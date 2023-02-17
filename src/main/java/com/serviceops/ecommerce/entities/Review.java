package com.serviceops.ecommerce.entities;


import jakarta.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;


    @Enumerated(EnumType.STRING)
    private Ratings ratings;

    @ManyToOne
    @JoinColumn(name = "product_product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_user_id")
    private User user;

    protected Review(){

    }

    public Review(Ratings ratings, Product product, User user) {
        this.ratings = ratings;
        this.product = product;
        this.user = user;
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



    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }



    public Ratings getRatings() {
        return ratings;
    }

    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }


}

