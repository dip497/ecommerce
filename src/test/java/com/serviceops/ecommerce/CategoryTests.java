package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.service.CategoryService;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class CategoryTests
{
    @Autowired
    CategoryService categoryService;
    @Autowired
    CategoryRepository categoryRepository;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    void contextLoads()
    {
       categoryService.createCategory(new CategoryDto(14L,"MensWear"));

    }

    void deleteCategory()
    {
        categoryService.removeCategoryById(18L);
    }


    void saveCategory(){
        categoryService.createCategory(new CategoryDto(1L,"Books"));
    }
    @Test
    void saveSubCategory(){
        //categoryService.createCategory(new CategoryDto("SmartPhone",categoryService.findCategoryById(1L)));
    }
    @Test
    void find()
    {

    logger.info("CAtegory ->{}",categoryRepository.findBycategoryName("Electronics"));
    }

    void findcorrespondingCategories(){
        logger.info("Caategory ->{}",categoryService.getSubcategories("Electronics"));
    }



}
