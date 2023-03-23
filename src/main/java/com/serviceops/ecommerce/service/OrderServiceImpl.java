package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.cart.CartItemDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    CustomRepository customRepository;
    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Autowired
    ProductRepository productRepository;


    @Autowired
    private UserRepository userRepository;


    @Override
    public void placeOrder(UserDto userDto) {
        User user = customRepository.findByColumn("userEmail",userDto.getUserEmail(),User.class);
           //     userRepository.findByUserEmail(userDto.getUserEmail());
        CartDto cartDto = cartService.cartItemsList(userDto);
        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setTotalPrice(cartDto.getCartValue());
      //  orderRepository.save(newOrder);
        customRepository.save(newOrder);

        for(CartItemDto cartItemDto: cartItemDtoList){

            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(cartItemDto.getProduct().getProductPrice());
            orderItem.setProduct(customRepository.findByColumn("productId",String.valueOf(cartItemDto.getProduct().getProductId()), Product.class));
                 //   productRepository.findById(cartItemDto.getProduct().getProductId()).get());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            customRepository.save(orderItem);
           // orderItemRepository.save(orderItem);

        }
        cartService.deleteUserCartItems(userDto);

    }

    @Override
    public List<Order> getAllOrders() {
        return customRepository.findAll(Order.class);
              //  orderRepository.findAll();
    }

    @Override
    public Long getTotalAmount() {
        return getAllOrders().stream().mapToLong(Order::getTotalPrice).sum();
    }





}