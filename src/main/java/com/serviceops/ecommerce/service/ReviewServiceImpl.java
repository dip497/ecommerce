package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.ProductRepository;
import com.serviceops.ecommerce.repository.ReviewRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepositoryDao;
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public boolean createReview(ReviewDto reviewDto) {
        Product product = productRepository.findById(reviewDto.getProduct().getProductId()).get();
        User user = userRepository.findById(reviewDto.getUser().getUserId()).get();
        Review review = new Review(reviewDto.getRatings(),product,user,reviewDto.getDescription());
        reviewRepositoryDao.save(review);
        return true;
    }


}
