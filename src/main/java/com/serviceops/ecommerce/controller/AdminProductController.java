package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SubCategoryService subCategoryService;
    @RequestMapping("/admin/Product/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model){
        model.addAttribute("product",productService.findProductById(Id));
        return "adminproduct";
    }
    @GetMapping("/admin/Product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long Id)
    {
//        Long id = productService.findProductById(Id).getProductSubCategory().getSubcategoryId();
        boolean isDeleted = productService.removeProduct(Id);
        System.out.println(isDeleted);
        return "redirect:/admin/Category";

    }

}
