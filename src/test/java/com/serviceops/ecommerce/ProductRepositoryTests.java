package com.serviceops.ecommerce;


import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import com.serviceops.ecommerce.repository.CategoryRepository;

import com.serviceops.ecommerce.service.CategoryService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.*;

@SpringBootTest
class ProductRepositoryTests {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    ProductRepository pRepo;
    @Autowired
    UserRepository uRepo;
    @Autowired
    ReviewRepository reRepo;
    @Autowired
    CategoryRepository crepo;

    @Autowired
    CategoryService categoryService;

    @Autowired
    SubCategoryRepository subCaterepo;
    @Test
    void contextLoads() {

        SubCategory sub = subCaterepo.findById(5L).get();
        Product product = pRepo.save(new Product("Hawkins", "New ",47848,sub));
      pRepo.save(new Product("wipro", "New ",448,sub));
      pRepo.save(new Product("Usha", "New ",4489,sub));
    }



    @Test
    public void saveproduct()
    {
        Category c = crepo.save(new Category("Haircare"));
        logger.info("Category -> {}",c);





    }
    @Test
    @Transactional
    @DirtiesContext
    void listOfSubcategories(){

       Set<SubCategory>  set1 = crepo.findById(6L).get().getSubCategorySet();
       String a =String.valueOf(set1.size());
       logger.info(a);
//        System.out.println(a.toString());
    }

    @Test
    @Transactional
    void getCategories()
    {
        List< CategoryDto> categoryDtos =categoryService.getAllCategroies();
        logger.info("Categoires ->{}",categoryDtos.toString());


    }



}
