package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;


@Controller
public class AdminCategoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    CategoryService CategoryService;

    @GetMapping("/admin/Category")
    public String getCategories(Model model)
    {

        model.addAttribute("categories", CategoryService.getAllCategroies());

        return "adminCategories";
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
        mav.addObject("category",categoryDto);
        return mav;
    }
    @RequestMapping("/admin/Category/save")
    public String getFormDetails(@ModelAttribute CategoryDto category)
    {
        logger.info("Category ->{}",category);
        CategoryService.createCategory(category);
        return "redirect:/admin/Category";

    }
    @RequestMapping("admin/Category/Update/{id}")
    public ModelAndView updateCategory(@PathVariable("id") Long id){

            CategoryDto categoryDto = CategoryService.findCategoryById(id);
            logger.info("first dto ->{}", categoryDto);
            ModelAndView mav = new ModelAndView("updateCategory");
            mav.addObject("updateCategory",categoryDto);
            return mav;
    }
    @RequestMapping("admin/Category/updated")
    public String updatedCategory(@ModelAttribute CategoryDto categoryDto){
        logger.info("Category ->{}",categoryDto);
        CategoryService.updateCategoryById(categoryDto);
        return "redirect:/admin/Category";
    }
    @RequestMapping("/admin/SubCategories/{id}")
    public String getSubCategory(@PathVariable("id") Long Id, Model model)
    {

        Set<SubCategoryDto> set = CategoryService.findCategoryById(Id).getSubCategorySet();

        model.addAttribute("subcategories",set);
        return "adminSubCategories";
    }


}
