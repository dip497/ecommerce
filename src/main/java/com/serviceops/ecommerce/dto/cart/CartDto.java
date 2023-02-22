package com.serviceops.ecommerce.dto.cart;

import java.util.List;

public class CartDto {

    private List<CartItemDto> cartItems;
    private long cartValue;

    public CartDto(List<CartItemDto> cartItems, long cartValue) {
        this.cartItems = cartItems;
        this.cartValue = cartValue;
    }

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public long getCartValue() {
        return cartValue;
    }

    public void setCartValue(long cartValue) {
        this.cartValue = cartValue;
    }
}
