package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.user.SignUpDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void TestFindUserByEmail() {
        User saveUser = userRepository.save(new User("dipendra", "sharma", "rohan@gmail.com", "12345678", Role.ADMIN));
        logger.info("user -> {}", userRepository.findByUserEmail("rohan@gmail.com"));
    }

    @Test
    void TestUserService(){
        SignUpDto user =new SignUpDto();
        user.setFirstName("user");
        user.setLastName("service");
        user.setEmail("test0d");
        user.setPassword("check");

        logger.info("user -> {}",   userService.signUp(user));

    }

}
