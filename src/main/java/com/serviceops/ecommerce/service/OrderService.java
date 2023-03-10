package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Order;


import java.util.List;

public interface OrderService {
    void placeOrder(UserDto userDto);
    List<Order> getAllOrders();

    Long getTotalAmount();
}