package com.serviceops.ecommerce.controller;


import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

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

    @RequestMapping("/register")
    public ModelAndView viewRegister(){
        ModelAndView mav = new ModelAndView("register");
        UserDto userDto = new UserDto();
        mav.addObject("user",userDto);
        return mav;
    }
    @RequestMapping("/admin/users/adduser")
    public ModelAndView viewAddUser(){
        ModelAndView mav = new ModelAndView("/admin/addnew");
        UserDto userDto = new UserDto();
        mav.addObject("user",userDto);
        return mav;
    }

    @RequestMapping("/admin/users/adduser/save")
    public String viewAddUserSave(@ModelAttribute UserDto userDto){
        boolean isSignUp = userService.signUp(userDto);
        System.out.println(isSignUp);
        return "redirect:/admin/users";
    }

    @RequestMapping("/register/save")
    public ModelAndView saveStudent(@ModelAttribute UserDto userDto){

        ModelAndView mav = new ModelAndView("registerMessage");
        System.out.println(userDto);
        boolean isSignUp = userService.signUp(userDto);
        if(isSignUp){
            mav.addObject("message","saved");
        }else{
            mav.addObject("message","failed");
        }
        return mav;
    }

    @RequestMapping("/admin/users")
    public ModelAndView viewAllUser(){
        ModelAndView mav = new ModelAndView("admin/admin_user");
        mav.addObject("users",userService.getAllUsers());
        return mav;
    }

    @GetMapping("/admin/users/deleteuser")
    public String editUser(@RequestParam("id") Long id){
        boolean isRemove = userService.deleteUser(id);
        System.out.println(isRemove);
        return "redirect:/admin/users";
    }



    @GetMapping("/admin/users/updateuser/{email}")
    public ModelAndView viewUpdateUser(@PathVariable(value = "email") String email){
        UserDto userDto = userService.getUser(email);
        System.out.println(userDto);
        ModelAndView model = new ModelAndView("admin/updateuser");
        model.addObject("user", userDto);
        return model;
    }

    @PostMapping("/admin/users/updateuser/save")
    public String saveUpdateUser(@ModelAttribute UserDto userDto){
        System.out.println(userDto);

        boolean update = userService.updateUser(userDto);
        return "redirect:/admin/users";
    }


}
