package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.User;

public interface CartService {


    void addToCart(AddToCartDto addToCartDto, Product product, User user);

    CartDto cartItemsList(User user);
    void updateCartItem(AddToCartDto cartDto, User user,Product product);
    void deleteCartItem(int id,int userId);
    void deleteCartItems(int userId);
    void deleteUserCartItems(User user);


}
