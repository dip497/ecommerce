package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.order.OrderDto;
import com.serviceops.ecommerce.entities.Order;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.OrderRepository;
import com.serviceops.ecommerce.service.OrderItemService;
import com.serviceops.ecommerce.service.OrderService;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderItemService orderItemList;
    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping("/user/allOrder")
    public ModelAndView listAllOrder(Principal principal){
        ModelAndView mav = new ModelAndView("/user/AllOrder");
        List<OrderItem> orderItem = orderItemList.getAllOderItem(userService.getUser(principal.getName()));
        System.out.println(Arrays.toString(orderItem.toArray()));
        mav.addObject("ordersList",orderItem);
        return mav;
    }

    @RequestMapping("/user/placeorder")
    public String placeOrder(Principal principal){
        orderService.placeOrder(userService.getUser(principal.getName()));
        return "redirect:/user/allOrder";
    }



}
