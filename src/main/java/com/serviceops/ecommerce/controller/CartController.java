package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.cart.AddToCartDto;
import com.serviceops.ecommerce.dto.cart.CartDto;
import com.serviceops.ecommerce.dto.cart.CartItemDto;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.repository.CartRepository;
import com.serviceops.ecommerce.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;



    @GetMapping("/user/")
    public ModelAndView addToCart(Principal principal, AddToCartDto addToCartDto){
        ModelAndView mav = new ModelAndView("user/cart");
        Product product = productService.findProductById(addToCartDto.getProductId());

        mav.addObject("cart",cartService.addToCart(addToCartDto,product,userService.getUser(principal.getName())));
        return mav;

    }

    @GetMapping("/user/cart")
    public ModelAndView cartItemsList(Principal principal){
        ModelAndView mav = new ModelAndView("user/cart");
        CartDto cartDto = cartService.cartItemsList(userService.getUser(principal.getName()));
        List<CartItemDto> cartItemsList = cartDto.getCartItems();
        mav.addObject("cart",cartItemsList);
        mav.addObject("cartValue",cartDto.getCartValue());
        return mav;
    }

    @RequestMapping ("/user/cart/delete{id}")
    public String deleteCartItem(@PathVariable (value="id") int id){
        cartService.deleteCartItem(id);
        return "redirect:/user/cart";
    }

    @RequestMapping("/user/cart/update{id}")
    public ModelAndView  viewUpdateCartItem(@PathVariable(value="id") int id) {

//        ModelAndView mav = new ModelAndView("user/cart");
//        cartService.updateCartItem(cartDto,userService.getUser(principal.getName()),product);

        AddToCartDto addToCartDto = new AddToCartDto();
        addToCartDto.setId(id);
        ModelAndView modelAndView = new ModelAndView("/user/quantityUpdate");
        modelAndView.addObject("addToCart",addToCartDto);


        return modelAndView;
    }

    @RequestMapping("/user/cart/update/save")
    public String updateCartItem(@ModelAttribute AddToCartDto addToCartDto,Principal principal){
        cartService.updateCartItem(addToCartDto, userService.getUser(principal.getName()));
        return "redirect:/user/cart";
    }


}
