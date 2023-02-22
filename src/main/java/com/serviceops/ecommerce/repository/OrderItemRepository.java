package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
