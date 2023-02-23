package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping("/admin/addSubcategory/{id}")
    public ModelAndView addSubCategory(@PathVariable("id") Long Id)
    {
        ModelAndView mav = new ModelAndView("addsubcategory");
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        subCategoryDto.setCategory(categoryService.findCategoryById(Id));
//        CategoryDto categoryById = categoryService.findCategoryById(Id);
        logger.info("subcatego -> {}",subCategoryDto);
        subCategoryDto.setSubcategoryName("stsdljfhsljdfh");

        mav.addObject("subcategory",subCategoryDto);

//        mav.addObject("id");
        return mav;
    }
    @RequestMapping("/admin/SubCategory/save/{id}")
    public String getFormDetails(@PathVariable("id") Long Id,@ModelAttribute SubCategoryDto subcategory)
    {
        logger.info("SubcategorySto->{}",subcategory);

        subcategory.setCategory(categoryService.findCategoryById(Id));

//        boolean a =subCategoryService.createSubCategory(subcategory);
//        System.out.println(a);
//        logger.info("SubCategory ->{}",subcategory);
//        logger.info("Category -> {}",category);
//        System.out.println(Id);
//        logger.info("category ->{}",category);
        return "redirect:/admin/Category";

    }


}
