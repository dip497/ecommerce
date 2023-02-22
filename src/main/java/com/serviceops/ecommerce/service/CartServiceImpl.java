package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.cart.CartItemDto;
import com.serviceops.ecommerce.entities.Cart;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.CartRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public void addToCart(AddToCartDto addToCartDto, Product product, User user) {
        Cart cart = new Cart(product, addToCartDto.getQuantity(), user);
        cartRepository.save(cart);

    }

    @Override
    public CartDto cartItemsList(User user) {
        List<Cart> cartList = cartRepository.findByUser(user);
        List<CartItemDto> cartItems = new ArrayList<>();

        for (Cart cart : cartList) {
            CartItemDto cartItemDto = getCartDto(cart);
            cartItems.add(cartItemDto);
        }
        long cartValue = 0;
        for (CartItemDto cartItemDto : cartItems) {
            cartValue += cartItemDto.getProduct()
                    .getProductPrice() * (cartItemDto.getQuantity());
        }
        return new CartDto(cartItems, cartValue);
    }


    public static CartItemDto getCartDto(Cart cart) {
        return new CartItemDto(cart);
    }

    @Override
    public void updateCartItem(AddToCartDto cartDto, User user, Product product) {
        Cart cart = cartRepository.getReferenceById(cartDto.getId());
        cart.setQuantity(cartDto.getQuantity());
        cartRepository.save(cart);
    }

    @Override
    public void deleteCartItem(int id, int userId) {
        if (!cartRepository.existsById(id))
            cartRepository.deleteById(id);

    }

    @Override
    public void deleteCartItems(int userId) {
        cartRepository.deleteAll();
    }

    @Override
    public void deleteUserCartItems(User user) {
        cartRepository.deleteByUser(user);
    }
}
