package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class AdminCategoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CategoryService CategoryService;

    @GetMapping("/admin/Category")
    public String getCategories(Model model)
    {

        model.addAttribute("categories", CategoryService.getAllCategroies());

        return "adminCategories";
    }
    @RequestMapping("/admin/Category/search")
    public ModelAndView getCategory( @RequestParam(value = "Category", required = true) String category){
        ModelAndView mav = new ModelAndView("adminCategories");
        System.out.println(category);
        List<CategoryDto> subcategories = CategoryService.getSubcategories(category);
        mav.addObject("categories",subcategories);
        return mav;

    }

    @GetMapping("/admin/Category/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long Id)
    {
        CategoryService.removeCategoryById(Id);
        return "redirect:/admin/Category";

    }
    @RequestMapping("/admin/addcategory")
    public ModelAndView addCategory()
    {
        ModelAndView mav = new ModelAndView("addcategory");
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setParent_categoryname("Electronics");
        mav.addObject("category",categoryDto);
        return mav;
    }
    @RequestMapping("/admin/Category/save")
    public String getFormDetails(@ModelAttribute CategoryDto category, Principal principal)
    {
        category.setCreatedBy(principal.getName());
        CategoryService.createCategory(category);
        return "redirect:/admin/Category";

    }
    @RequestMapping("admin/Category/Update/{id}")
    public ModelAndView updateCategory(@PathVariable("id") Long id){

            CategoryDto categoryDto = CategoryService.findCategoryById(id);
            ModelAndView mav = new ModelAndView("updateCategory");
            mav.addObject("updateCategory",categoryDto);
            return mav;
    }
    @RequestMapping("admin/Category/updated")
    public String updatedCategory(@ModelAttribute CategoryDto categoryDto,Principal principal){
        categoryDto.setUpdatedBy(principal.getName());
        CategoryService.updateCategoryById(categoryDto);
        return "redirect:/admin/Category";
    }



}
