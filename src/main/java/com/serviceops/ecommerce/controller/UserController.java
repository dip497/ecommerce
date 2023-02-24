package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.dto.user.UserPasswordDto;
import com.serviceops.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user/update")
    public ModelAndView viewUpdateUser(Principal principal){
        ModelAndView mv = new ModelAndView("/user/updateUser");
        UserDto userDto = userService.getUser(principal.getName());
        mv.addObject("user",userDto);
        return mv;
    }

    @PostMapping("/user/update/save")
   public String updateUserSave(@ModelAttribute UserDto userDto){
        userService.updateUser(userDto);
        return "redirect:/user/home";

    }

    @GetMapping("/user/changePassword")
    public ModelAndView viewUpdatePassword(Principal principal){
        ModelAndView mv = new ModelAndView("user/updateUserPassword");
        UserPasswordDto dto = new UserPasswordDto();
        dto.setEmail(principal.getName());
        mv.addObject("passDto",dto);
        return mv;

    }

    @PostMapping("/user/updatePassword/save")
    public String UpdatePasswordSave(@ModelAttribute UserPasswordDto userPasswordDto){
        if(userService.updatePassword(userPasswordDto)){
            return "redirect:/user/home";
        }else{
            return "redirect:/user/changePassword";
        }

    }

}
