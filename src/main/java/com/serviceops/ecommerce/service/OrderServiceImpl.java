package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.cart.CartItemDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.OrderNotFoundException;
import com.serviceops.ecommerce.repository.OrderItemRepository;
import com.serviceops.ecommerce.repository.OrderRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    UserService userService;
    @Autowired
    private UserRepository userRepository;


    @Override
    public void placeOrder(UserDto userDto) {
        User user = userRepository.findByUserEmail(userDto.getUserEmail());
        CartDto cartDto = cartService.cartItemsList(userDto);
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
        cartService.deleteUserCartItems(userDto);

    }

    @Override
    public List<Order> ordersList(UserDto
                                          user){
        return orderRepository.findAllByUser(userRepository.findByUserEmail(user.getUserEmail()));
    }

    @Override
    public List<OrderItem> orderItemList(UserDto userDto){


        List<Order>  orderList= orderRepository.findAllByUser(userRepository.findByUserEmail(userDto.getUserEmail()));
        List<OrderItem> orderItemList = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.size());
            for (int j = i; j < orderList.get(i).getOrderItems().size(); j++) {
                if(orderList.get(i).getUser() == userRepository.findByUserEmail(userDto.getUserEmail())) {
                    orderItemList.add(orderItemList.get(j));
                }


            }


        }
        return orderItemList;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Long getTotalAmount() {
        return getAllOrders().stream().mapToLong(Order::getTotalPrice).sum();
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