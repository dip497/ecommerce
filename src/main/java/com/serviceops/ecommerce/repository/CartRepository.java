package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.Cart;
import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    List<Cart> findByUser(User user);

    List<Cart> deleteByUser(User user);


}