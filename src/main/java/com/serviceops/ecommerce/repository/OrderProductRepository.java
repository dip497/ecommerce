package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
