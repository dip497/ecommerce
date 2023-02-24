package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {

    List<Review> findAllByProductProductId(Long id);

    List<Review> findAllByUser(User user);
}
