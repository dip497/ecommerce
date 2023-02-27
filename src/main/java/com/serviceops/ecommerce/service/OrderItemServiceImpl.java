package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.repository.OrderItemRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<OrderItem> getAllOderItem(UserDto user) {
        return orderItemRepository.retriveOrder(userRepository.findByUserEmail(user.getUserEmail()));

    }


}