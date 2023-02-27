package com.serviceops.ecommerce.dto.order;

import com.serviceops.ecommerce.dto.user.UserDto;
import jakarta.validation.constraints.NotNull;


import java.util.List;


public class OrderDto {
    private  Integer id;
    private @NotNull long totalPrice;
    private @NotNull UserDto userDto;
    private  List<OrderItemDto> orderItems;


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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }
}