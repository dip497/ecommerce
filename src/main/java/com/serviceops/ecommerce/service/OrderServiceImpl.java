package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.cart.CartItemDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.OrderNotFoundException;
import com.serviceops.ecommerce.repository.OrderItemRepository;
import com.serviceops.ecommerce.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private CartServiceImpl cartService;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public void placeOrder(User user) {
        CartDto cartDto = cartService.cartItemsList(user);
        List<CartItemDto> cartItemDtoList = cartDto.getCartItems();

        Order newOrder = new Order();
        newOrder.setUser(user);
        newOrder.setTotalPrice(cartDto.getCartValue());
        orderRepository.save(newOrder);

        for(CartItemDto cartItemDto: cartItemDtoList){

            OrderItem orderItem = new OrderItem();
            orderItem.setPrice(cartItemDto.getProduct().getProductPrice());
            orderItem.setProduct(cartItemDto.getProduct());
            orderItem.setQuantity(cartItemDto.getQuantity());
            orderItem.setOrder(newOrder);
            orderItemRepository.save(orderItem);

        }
        cartService.deleteUserCartItems(user);

    }

    @Override
    public List<Order> ordersList(User user){
        return orderRepository.findAllByUser(user);
    }

    @Override
    public Order getOrder(Integer orderId) throws OrderNotFoundException {
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            return order.get();
        }
        throw new OrderNotFoundException("Order Not Found");

    }



}
