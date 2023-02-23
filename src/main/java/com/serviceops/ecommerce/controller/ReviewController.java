package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.ReviewDto;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.service.ReviewService;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @RequestMapping("/user/allorder/addreview")
    public ModelAndView viewAddUser(@ModelAttribute ProductDto productDto){
        System.out.println(productDto);
        ModelAndView mav = new ModelAndView("/user/addReview");
        ReviewDto reviewDto = new ReviewDto();
//        reviewDto.setProduct();
        mav.addObject("reviewDto",reviewDto);
        return mav;
    }

    @RequestMapping("/user/allorder/addreview/save")
    public String viewAddUserSave(@ModelAttribute ReviewDto reviewDto){
        System.out.println(reviewDto);
        reviewService.createReview(reviewDto);
        return "/user/allOrder";
    }

}
