package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Product.ProductDto;

import com.serviceops.ecommerce.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//@Controller
public class AdminSubCategoryController {


//    @Autowired
//    private CategoryService categoryService;
   // private Logger logger = LoggerFactory.getLogger(this.getClass());
//    @Autowired
//    SubCategoryService subCategoryService;
//
//    @GetMapping("/admin/SubCategory/delete/{id}")
//    public String deleteCategory(@PathVariable("id") Long Id)
//    {
//        Long id = subCategoryService.findSubCategoryById(Id).getCategory().getCategoryId();
//        subCategoryService.removeSubCategoryById(Id);
//        return "redirect:/admin/SubCategories/"+id;
//
//    }
//    @RequestMapping("/admin/addSubcategory/{id}")
//    public ModelAndView addSubCategory(@PathVariable("id") Long Id)
//    {
//        ModelAndView mav = new ModelAndView("addsubcategory");
//        SubCategoryDto subCategoryDto = new SubCategoryDto();
//        subCategoryDto.setCategory(categoryService.findCategoryById(Id));
////        CategoryDto categoryById = categoryService.findCategoryById(Id);
//        logger.info("subcatego -> {}",subCategoryDto);
//        subCategoryDto.setSubcategoryName("stsdljfhsljdfh");
//
//        mav.addObject("subcategory",subCategoryDto);
//
////        mav.addObject("id");
//        return mav;
//    }
//    @RequestMapping("/admin/SubCategory/save/{id}")
//    public String getFormDetails(@PathVariable("id") Long Id,@ModelAttribute SubCategoryDto subcategory)
//    {
//        logger.info("SubcategorySto->{}",subcategory);
//
//        subcategory.setCategory(categoryService.findCategoryById(Id));
//        subCategoryService.createSubCategory(subcategory);
//
////        boolean a =subCategoryService.createSubCategory(subcategory);
////        System.out.println(a);
////        logger.info("SubCategory ->{}",subcategory);
////        logger.info("Category -> {}",category);
////        System.out.println(Id);
////        logger.info("category ->{}",category);
//        return "redirect:/admin/Category";
//
//    }
//    @RequestMapping("admin/SubCategory/Update/{id}")
//    public ModelAndView updateCategory(@PathVariable("id") Long id){
//
//        SubCategoryDto subCategoryById = subCategoryService.findSubCategoryById(id);
//        logger.info("first dto ->{}", subCategoryById);
//        ModelAndView mav = new ModelAndView("updateSubCategory");
//        mav.addObject("updateSubCategory",subCategoryById);
//        return mav;
//    }
//    @RequestMapping("admin/SubCategory/updated/{id}")
//    public String updatedCategory(@PathVariable("id") Long Id,@ModelAttribute SubCategoryDto updateSubCategory){
//        updateSubCategory.setSubcategoryId(Id);
//
//        //subCategoryDto.setCategory(subCategoryService.findSubCategoryById(Id).getCategory());
//        logger.info("Subcategory ->{}",updateSubCategory);
//        subCategoryService.updateSubCategoryById(updateSubCategory);
//        //subCategoryService.updateSubCategoryById(subCategoryDto);
//
//        return "redirect:/admin/Category";
//    }


}
