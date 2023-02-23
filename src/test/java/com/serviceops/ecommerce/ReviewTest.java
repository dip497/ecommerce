package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ReviewService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ReviewTest
{
    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductService productService;

    @Test
    void contextLoads()
    {


    }
    @Test
    void deleteCategory()
    {


    }
}
