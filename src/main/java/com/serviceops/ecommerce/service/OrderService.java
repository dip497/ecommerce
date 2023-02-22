package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.User;

import java.util.List;

public interface OrderService {
    void placeOrder(User user);
    public List<Order> ordersList(User user);
    public Order getOrder(Integer orderId);
}
