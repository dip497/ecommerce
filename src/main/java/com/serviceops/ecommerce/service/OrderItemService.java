package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.OrderItem;

import java.util.List;


public interface OrderItemService {

    void addOrderedProduct(OrderItem orderItem);
    List<OrderItem>  getAllOderItem(UserDto user);



}