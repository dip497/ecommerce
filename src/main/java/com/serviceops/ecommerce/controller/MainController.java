package com.serviceops.ecommerce.controller;


import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Principal principal){
        System.out.println(principal.getName());
        return "admin/admin_home";
    }

    @GetMapping("/user/home")
    public String viewUserHomePage(){
        return "user/user_home";
    }
    @GetMapping("/home")
    public String viewDefaultHomePage(){
        return "home";
    }
    @GetMapping("/register")
    public String viewRegister(){

        return "register";
    }



}
