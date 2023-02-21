package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Review;

import java.util.List;


public interface ReviewService {

    public List<Review> findAll();
    public Review updateReviewById(Long Id);
    public void deleteReviewById(Long Id);



}
