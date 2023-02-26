package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.repository.ReviewRepository;

import java.util.List;


public interface ReviewService {

     boolean createReview(ReviewDto Review);

     List<ReviewDto> productReview(Long productId);

     List<ReviewDto> userReview(UserDto userDto);



}
