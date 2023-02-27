package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Cart;

public interface CartService {


    Cart addToCart(AddToCartDto addToCartDto, ProductDto product, UserDto user);

    CartDto cartItemsList(UserDto user);

    void updateCartItem(AddToCartDto cartDto, UserDto user);


    void deleteCartItem(int id);


    void deleteUserCartItems(UserDto user);


}