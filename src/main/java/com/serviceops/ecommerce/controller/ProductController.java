package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;
    @RequestMapping("/user/Product/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model){
        model.addAttribute("product",productService.findProductById(Id));
        return "insideproduct";
        }
}
