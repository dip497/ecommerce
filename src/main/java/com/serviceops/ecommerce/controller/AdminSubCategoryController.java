package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Set;

@Controller
public class AdminSubCategoryController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    SubCategoryService subCategoryService;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/admin/SubCategory/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long Id)
    {
        Long id = subCategoryService.findSubCategoryById(Id).getCategory().getCategoryId();
        subCategoryService.removeSubCategoryById(Id);
        return "redirect:/admin/SubCategories/"+id;

    }
    @RequestMapping("/admin/addSubCategory/{id}")
    public ModelAndView addSubCategory(@PathVariable("id") Long Id)
    {
        ModelAndView mav = new ModelAndView("addsubcategory");
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        CategoryDto categoryById = categoryService.findCategoryById(Id);
        subCategoryDto.setCategory(categoryById);
        mav.addObject("subcategory",subCategoryDto);
        return mav;
    }
    @RequestMapping("/admin/SubCategory/save")
    public String getFormDetails(@ModelAttribute SubCategoryDto category)
    {
        Long a = category.getCategory().getCategoryId();
        subCategoryService.createSubCategory(category);
        return "redirect:/admin/SubCategory/{"+a+"}";

    }


}
