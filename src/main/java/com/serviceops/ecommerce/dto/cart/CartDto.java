package com.serviceops.ecommerce.dto.cart;



import java.util.List;

public class CartDto {

    private List<CartItemDto> cartItems;
    private long cartValue;

    public CartDto(List<CartItemDto> cartItemDtoList, long cartValue) {
        this.cartItems = cartItemDtoList;
        this.cartValue = cartValue;
    }
    
    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItemDtoList) {
        this.cartItems = cartItemDtoList;
    }

    public long getCartValue() {
        return cartValue;
    }

    public void setCartValue(long cartValue) {
        this.cartValue = cartValue;
    }

    @Override
    public String toString() {
        return "CartDto{" +
                "cartItems=" + cartItems +
                ", cartValue=" + cartValue +
                '}';
    }
}
