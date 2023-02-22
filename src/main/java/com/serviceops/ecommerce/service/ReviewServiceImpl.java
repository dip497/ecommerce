package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.exceptions.CategoryExist;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.ReviewRepository;
import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {


    @Autowired
    ReviewRepository reviewRepositoryDao;

    @Override
    public List<Review> findAll() {
        return reviewRepositoryDao.findAll();
    }
    @Override
    public Review updateReviewById(Review review) {
        return reviewRepositoryDao.save(review);
    }
    @Override
    public void deleteReviewById(Long Id) {
        reviewRepositoryDao.deleteById(Id);
    }
    @Override
    public Review createReview(Review Review) {
      return   reviewRepositoryDao.save(Review);
    }
}
