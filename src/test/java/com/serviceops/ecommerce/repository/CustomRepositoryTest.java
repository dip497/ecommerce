package com.serviceops.ecommerce.repository;
import com.serviceops.ecommerce.entities.*;

import java.sql.Timestamp;

import com.serviceops.ecommerce.utils.Helper;
import com.serviceops.ecommerce.utils.PasswordHelper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomRepositoryTest {

    @Autowired
    CustomRepository customRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    void findByColumn() {
        // for user
        User byEmail = customRepository.findByColumn("userEmail","prakhar@gmail.com", User.class);
        logger.info("found by email -> {}" , byEmail);
    }

    @Test
    void findAll(){
        // user
        List<User> allUser = customRepository.findAll(User.class);
        logger.info("found all user -> {}", allUser);

        // product
        List<Product> allProduct = customRepository.findAll(Product.class);
        logger.info("found all product -> {}", allProduct);
    }

    @Test
    void save(){
        Long userId = 2L;
        String userFirstName = "john";
        String userLastName = "sharma";
        String userEmail = "johnsharma@gmil.com";
        String userPassword = "123";
        Role userRole = Role.ADMIN;
        User newUser = new User(userFirstName,userLastName,userEmail,userPassword,userRole);

        customRepository.save(newUser);
        //customRepository.save(newUser);
    }

    @Test
    void deleteById(){
        customRepository.deleteById(User.class,4L,"userId");
    }

    @Test
    void findAllByColumn(){

        List<Review> user = customRepository.findAllByColumnName(Review.class, "user", "userId","1");
        user.forEach(System.out::println);
    }

    @Test
    void updateColumn(){
        customRepository.updateColumn(User.class,"userPassword", PasswordHelper.hashPassword("test"));
    }


}