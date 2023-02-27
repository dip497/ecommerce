package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;

import java.util.List;

public interface OrderService {
    void placeOrder(UserDto userDto);
    public List<Order> ordersList(UserDto user);
    public Order getOrder(Integer orderId);
    List<OrderItem> orderItemList(UserDto user);

    List<Order> getAllOrders();

    Long getTotalAmount();


}