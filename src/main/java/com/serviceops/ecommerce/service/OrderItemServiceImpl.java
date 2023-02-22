package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.repository.OrderItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void addOrderedProduct(OrderItem orderItem){
        orderItemRepository.save(orderItem);
    }

}
