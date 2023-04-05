package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.annotation.MeasureExecutionTime;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ReviewService reviewService;
    @RequestMapping("/user/Product/{id}")
    @MeasureExecutionTime
    public String getAllProducts(@PathVariable("id") Long id, Model model) {
        model.addAttribute("products",categoryService.findCategoryById(id).getProductDtoList());
        return "products";
    }
    @RequestMapping("/user/aboutProducts/{id}")
    @MeasureExecutionTime
    public String getInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product",productService.findProductById(id));
        model.addAttribute("reviews",reviewService.productReview(id));
        return "/user/insideproduct";
    }
}
