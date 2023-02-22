package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.OrderItem;

import java.util.List;


public interface OrderItemService {

    public void addOrderedProduct(OrderItem orderItem);
    List<OrderItem>  getAllOderItem();

}
