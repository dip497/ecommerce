package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.repository.ReviewRepository;

import java.util.List;


public interface ReviewService {

    public List<Review> findAll();
    public Review updateReviewById(Review review);
    public void deleteReviewById(Long Id);
    public Review createReview(Review Review);



}
