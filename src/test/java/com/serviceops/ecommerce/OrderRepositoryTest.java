package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import com.serviceops.ecommerce.service.OrderService;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class OrderRepositoryTest {
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    ProductRepository productrepo;
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private CategoryRepository crepo;
//
//    @Autowired
//    private SubCategoryRepository subCategoryrepo;
//    @Autowired
//    private OrderItemRepository orderItemRepository;
//
    @Autowired
   private OrderService orderService;
    @Autowired
    private UserRepository userRepository;

    //
    @Test
   void orderProductRepo() {
        System.out.println(orderService.getTotalAmount());
    }
}
