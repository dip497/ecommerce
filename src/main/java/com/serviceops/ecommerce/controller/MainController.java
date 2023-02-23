package com.serviceops.ecommerce.controller;


import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

    @Autowired
    private ProductService productService;
    @Autowired
    private UserService userService;
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
    public String viewAdminHomePage(){
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
    public String viewAddUserSave(@ModelAttribute UserDto userDto){
        userService.signUp(userDto);
        return ADMIN_USERS_URL;
    }

    @RequestMapping("/register/save")
    public ModelAndView saveStudent(@ModelAttribute UserDto userDto){

        ModelAndView mav = new ModelAndView("registerMessage");
        boolean isSignUp = userService.signUp(userDto);
        if(isSignUp){
            mav.addObject("message","saved");
        }else{
            mav.addObject("message","failed");
        }
        return mav;
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
    public String saveUpdateUser(@ModelAttribute UserDto userDto){
        userService.updateUser(userDto);
        return ADMIN_USERS_URL;
    }


}
