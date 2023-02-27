package com.serviceops.ecommerce.controller;
import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/user/Categories")
    public String getAllCategories(Model model)
    {

        model.addAttribute("allcategories",categoryService.getAllCategroies());
        return "/user/categories";
    }
    @RequestMapping("/user/Category/search")
    public ModelAndView getCategory(@RequestParam(value = "Category", required = true) String category){
        ModelAndView mav = new ModelAndView("/user/categories");
        List<CategoryDto> subcategories = categoryService.getSubcategories(category);

        mav.addObject("allcategories",subcategories);
        return mav;

    }
    @RequestMapping("/user/AllProducts/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model)
    {
        List<ProductDto> productSet = categoryService.findCategoryById(Id).getProductDtoList();
        model.addAttribute("products",productSet);
        return "products";
    }
}
