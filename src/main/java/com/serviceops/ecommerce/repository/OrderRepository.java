package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {


    List<Order> findAll();


}
