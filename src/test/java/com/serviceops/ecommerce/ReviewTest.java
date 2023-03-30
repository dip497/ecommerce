package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.entities.Ratings;
import com.serviceops.ecommerce.repository.ReviewRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ReviewService;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTest {
    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @Autowired
    ReviewRepository reviewRepository;

    @Autowired
    UserRepository userRepository;


    void contextLoads() {
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setUser(userService.getUser("prakhar@gmail.com"));
        reviewDto.setProduct(productService.findProductById(6L));
        reviewDto.setRatings(Ratings.FOUR);
        reviewDto.setDescription("nice");
        reviewService.createReview(reviewDto);

    }

    @Test
    void findReviewByProduct() {
        System.out.println(reviewService.productReview(1L));

    }
    @Test
    void testReviewRepository(){
        System.out.println(reviewRepository.findAllByUser(userRepository.findByUserEmail("prakhar@gmail.com")));
    }


    void testReviewRepositoryDelete(){
        reviewRepository.deleteById(5L);
    }
}
