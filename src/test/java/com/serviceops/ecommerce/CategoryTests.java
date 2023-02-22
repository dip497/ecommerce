package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryTests
{
    @Autowired
    CategoryService categoryService;

    @Test
    void contextLoads()
    {
       categoryService.createCategory(new CategoryDto(14L,"MensWear"));

    }
    @Test
    void deleteCategory()
    {
        categoryService.removeCategoryById(18L);
    }
}
