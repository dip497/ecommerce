package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
