package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.SubCategoryService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;

@SpringBootTest
public class SubCategoryTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SubCategoryService subCategoryService;

    @Autowired
    CategoryService categoryService;
    @Test
    void contextLoads() {


    }

    @Test
    void saveSubCategory()
    {
       Set<SubCategoryDto> set =categoryService.findCategoryById(6L).getSubCategorySet();
       logger.info("Set ->{}",set);
    }
    @Test
    void getAllsubcategories()
    {
        List<SubCategoryDto> list =  subCategoryService.getAllSubCategroies();
        logger.info("list -> {}",list);

    }
    @Test
    void deleteSubCategories()
    {
//        SubCategoryDto subCategoryById = subCategoryService.findSubCategoryById(13L);
//        logger.info("SubCategory -> {}",subCategoryById);
        subCategoryService.removeSubCategoryById(6L);
    }
    @Test
    void subcategory()
    {
        SubCategoryDto subCategoryDto = new SubCategoryDto();
        CategoryDto categoryById = categoryService.findCategoryById(21L);
        subCategoryDto.setCategory(categoryById);
        subCategoryDto.setSubcategoryName("Check");
        subCategoryService.createSubCategory(subCategoryDto);
    }
}
