package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.user.SignInDto;
import com.serviceops.ecommerce.dto.user.SignUpDto;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public Boolean signUp(@RequestBody SignUpDto signUpDto) throws CustomException {
        return userService.signUp(signUpDto);
    }

    @PostMapping("/signin")
    public Boolean signIn(@RequestBody SignInDto signInDto) throws CustomException {
        return userService.signIn(signInDto);
    }


}
