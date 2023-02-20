package com.serviceops.ecommerce;


import com.serviceops.ecommerce.entities.*;
import com.serviceops.ecommerce.repository.*;
import com.serviceops.ecommerce.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

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
    SubCategoriesRepository subCaterepo;
    @Test
    void contextLoads() {
        Category c = crepo.save(new Category("Electronics"));
        SubCategories subcat = subCaterepo.save(new SubCategories("Laptop",c));
        Product product = pRepo.save(new Product("Lenovo", "New ",47848,subcat));
    }



    @Test
    @Transactional
    public void saveproduct()
    {
        Category c = crepo.save(new Category("Electronics"));
        SubCategories subcat = subCaterepo.save(new SubCategories("Laptop",c));
        Product product = pRepo.save(new Product("Lenovo", "New ",47848,subcat));


        logger.info("Product Details - {}",product);


    }




}
