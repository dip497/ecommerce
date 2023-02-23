package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ProductServiceImpl;
import com.serviceops.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private  ProductService productService;
    @Autowired
    private ReviewService reviewService;
    @RequestMapping("/user/Product/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model) {
        model.addAttribute("product", productService.findProductById(Id));
        model.addAttribute("reviews",reviewService.productReview(Id));
        return "insideproduct";
    }
}
