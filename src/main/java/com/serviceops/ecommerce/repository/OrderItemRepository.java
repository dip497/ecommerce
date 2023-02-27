package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    @Query(value = "select a, b from OrderItem as a join a.order b on a.order.id = b.id and b.user=:user")
    List<OrderItem> retriveOrder(User user);

}
