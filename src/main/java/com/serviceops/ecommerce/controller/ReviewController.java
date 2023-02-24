package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.OrderItem;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ReviewService;
import com.serviceops.ecommerce.service.SubCategoryService;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;


    @GetMapping("/user/allorder/addreview/{product}")
    public ModelAndView viewAddUser(@PathVariable(value = "product") Long product){
        System.out.println(product);
        ModelAndView mav = new ModelAndView("/user/addReview");
        ReviewDto reviewDto = new ReviewDto();
        reviewDto.setProduct(productService.findProductById(product));
        System.out.println(reviewDto);
        mav.addObject("reviewDto",reviewDto);
        return mav;
    }

    @RequestMapping("/user/allorder/addreview/save/{id}")
    public String viewAddUserSave(@PathVariable("id") Long  id ,@ModelAttribute ReviewDto reviewDto, Principal principal){
        reviewDto.setProduct(productService.findProductById(id));
        reviewDto.setUser(userService.getUser(principal.getName()));
        System.out.println("in save");
        System.out.println("raviewDto"+ reviewDto);

        reviewService.createReview(reviewDto);
        return "redirect:/user/allOrder";
    }

    @GetMapping("/user/allReview")
    public ModelAndView viewUserAllReview(Principal principal){
        ModelAndView mv = new ModelAndView("/user/showReview");
        mv.addObject("reviews",reviewService.userReview(userService.getUser(principal.getName())));
        return mv;

    }

}
