package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class SubCategoryController {

    @Autowired
    SubCategoryService subCategoryService;


    @RequestMapping("/user/AllProducts/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model)
    {
        Set<ProductDto> productSet = subCategoryService.findSubCategoryById(Id).getProductSet();
        model.addAttribute("products",productSet);
        return "products";
    }

}
