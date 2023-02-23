package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.ProductRepository;
import com.serviceops.ecommerce.repository.ReviewRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;


    @Override
    public boolean createReview(ReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProduct().getProductId()).get();
        User user = userRepository.findById(reviewDto.getUser().getUserId()).get();
        Review review = new Review(reviewDto.getRatings(),product,user,reviewDto.getDescription());
        reviewRepository.save(review);
        return true;
    }

    @Override
    public List<ReviewDto> productReview(Long productId){
        List<Review> reivews = reviewRepository.findAllByProductProductId(productId);

        return reivews.stream().map(this::entityToDto).toList();
    }

    private ReviewDto entityToDto(Review review){
        ProductDto product = productService.findProductById(review.getProduct().getProductId());
        UserDto user = userService.getUser(review.getUser().getUserEmail());
        return new ReviewDto(review.getReviewId(),review.getDescription(),review.getRatings(),product,user);
    }


}
