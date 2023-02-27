package com.serviceops.ecommerce.controller;


import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.service.OrderService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    private  static final String ADMIN_USERS_URL = "redirect:/admin/users";

    @GetMapping("/")
    public String viewHomePage(){
        return "index";
    }

    @GetMapping("/login")
    public String viewLogin(){
        return "login";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Model model){
        model.addAttribute("totalAmount",orderService.getTotalAmount());
        System.out.println(orderService.getTotalAmount());
        return "admin/admin_home";
    }

    @GetMapping("/user/home")
    public String viewUserHomePage(Model model){
        model.addAttribute("products", productService.getAllProducts());
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
    public String viewAddUserSave(@ModelAttribute UserDto userDto,Principal principal){
        userDto.setCreatedBy(principal.getName());
        userService.signUp(userDto);
        return ADMIN_USERS_URL;
    }

    @RequestMapping("/register/save")
    public String saveStudent(@ModelAttribute UserDto userDto){

        userDto.setCreatedBy(userDto.getUserEmail());
        userDto.setUserRole(Role.CUSTOMER);
        boolean isSignUp = userService.signUp(userDto);
        if(isSignUp){
           return "redirect:/register?success";
        }else{
            return "redirect:/register?error";
        }

    }

    @GetMapping("/admin/users")
    public ModelAndView viewAllUser(){
        ModelAndView mav = new ModelAndView("admin/admin_user");
        mav.addObject("users",userService.getAllUsers());
        return mav;
    }

    @GetMapping("/admin/users/deleteuser")
    public String editUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
        return ADMIN_USERS_URL;
    }



    @GetMapping("/admin/users/updateuser/{email}")
    public ModelAndView viewUpdateUser(@PathVariable(value = "email") String email){
        UserDto userDto = userService.getUser(email);
        ModelAndView model = new ModelAndView("admin/updateuser");
        model.addObject("user", userDto);
        return model;
    }

    @PostMapping("/admin/users/updateuser/save")
    public String saveUpdateUser(@ModelAttribute UserDto userDto,Principal principal){
        userDto.setUpdatedBy(principal.getName());
        userService.updateUser(userDto);
        return ADMIN_USERS_URL;
    }


}
