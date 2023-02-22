package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.User;

import java.util.List;


public interface OrderItemService {

    public void addOrderedProduct(OrderItem orderItem);
    List<OrderItem>  getAllOderItem(UserDto user);



}
