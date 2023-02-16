package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/user/")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

}
