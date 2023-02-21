package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;
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

}
