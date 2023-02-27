package com.serviceops.ecommerce.dto.order;

import com.serviceops.ecommerce.dto.user.UserDto;


import java.util.List;


public class OrderDto {
    private final Integer id;
    private final long totalPrice;
    private final UserDto userDto;
    private final List<OrderItemDto> orderItems;

    public OrderDto(Integer id, long totalPrice, UserDto user, List<OrderItemDto> orderItems) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.userDto = user;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public UserDto getUser() {
        return userDto;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
}