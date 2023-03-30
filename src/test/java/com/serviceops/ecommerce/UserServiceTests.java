package com.serviceops.ecommerce;


import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.SpringVersion;
import org.springframework.security.test.context.support.WithMockUser;

import javax.swing.*;

import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Mock
    private UserRepository userRepository;

    @MockBean
    private UserService userService;

    private UserDto userDto;
    @Test

    void test(){
        System.out.println(SpringVersion.getVersion());
    }


    @Test
    void whenGetUser_ReturnUserDto(){
        when(userService.getUser("")).thenReturn(userDto);

    }


}
