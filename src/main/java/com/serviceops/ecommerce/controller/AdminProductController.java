package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.service.CategoryService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService CategoryService;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ReviewService reviewService;

    @RequestMapping("/admin/AllProducts/{id}")
    public String getAllProducts(@PathVariable("id") Long Id, Model model)
    {
        System.out.println(Id);
        List<ProductDto> productSet = CategoryService.findCategoryById(Id).getProductDtoList();
        if(!productSet.isEmpty()){
            model.addAttribute("products",productSet);

        }else{
            model.addAttribute("id",Id);
            model.addAttribute("isEmpty",true);
            model.addAttribute("productDto",new ProductDto());

            return "addProduct";

        }

        return "adminproducts";
    }


    @RequestMapping("/admin/Product/{id}")
    public String getCategoryProducts(@PathVariable("id") Long Id, Model model){
        model.addAttribute("product",productService.findProductById(Id));
        model.addAttribute("reviews",reviewService.productReview(Id));
        return "/user/insideproduct";
    }
    @GetMapping("/admin/Product/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long Id)
    {
        boolean isDeleted = productService.removeProduct(Id);
        System.out.println(isDeleted);
        return "redirect:/admin/Category";
    }
    @RequestMapping("/admin/addProduct/{id}")
    public ModelAndView addProduct(@PathVariable("id") Long Id)
    {
        ModelAndView mav = new ModelAndView("addProduct");
        ProductDto productDto = new ProductDto();
        productDto.setProductCategory(productService.findProductCategory(Id));
        productDto.setProductId(0L);
        productDto.setProductName("yudewuy");
        productDto.setProductPrice(2873);
        productDto.setProductDesc("ejbfw");
        logger.info("productDto -> {}",productDto);

        mav.addObject("productDto",productDto);
        return mav;
    }
    @RequestMapping("/admin/Product/save/{id}")
    public String getFormDetails(@PathVariable("id") Long Id,@ModelAttribute ProductDto productDto)
    {
        productDto.setProductCategory(CategoryService.findCategoryById(Id));
        productService.createProduct(productDto);
        return "redirect:/admin/Category";

    }
    @RequestMapping("admin/Product/Update/{id}")
    public ModelAndView updateProduct(@PathVariable("id") Long id){
        ProductDto productById = productService.findProductById(id);
        logger.info("first dto ->{}", productById);
        ModelAndView mav = new ModelAndView("updateProduct");
        mav.addObject("productDto",productById);
        return mav;
    }
    @RequestMapping("admin/Product/updated/{id}")
    public String updatedProduct(@PathVariable("id") Long Id,@ModelAttribute ProductDto productDto){
        productDto.setProductId(Id);
        productService.updateProduct(productDto);
        return "redirect:/admin/Category";
    }

}
