package com.serviceops.ecommerce.controller;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.CategoryServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;


@Controller
public class CategoryController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/user/Categories")
    public String getAllCategories(Model model)
    {

        model.addAttribute("allcategories",categoryService.getAllCategroies());
        return "categories";
    }
    @RequestMapping("/user/SubCategories/{id}")
    public String  getSubCategory(@PathVariable("id") Long Id, Model model)
    {
        Set<SubCategoryDto> set = categoryService.findCategoryById(Id).getSubCategorySet();
        model.addAttribute("subcategories",set);
        return "subcategories";
    }
}
