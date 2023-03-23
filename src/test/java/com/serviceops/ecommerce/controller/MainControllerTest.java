package com.serviceops.ecommerce.controller;
import com.serviceops.ecommerce.dto.Category.CategoryDto;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.service.OrderService;
import com.serviceops.ecommerce.service.ProductService;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(MainController.class)
@ActiveProfiles(value = "test")
class MainControllerTest {

    @InjectMocks
    MainController mainController;

    @MockBean
    UserService userService;

    @MockBean
    ProductService productService;

    @MockBean
    OrderService orderService;
    @Autowired
    private WebApplicationContext context;

    @Autowired
    MockMvc mockMvc;




    @Test
    void viewHomePage() {
    }

    @Test
    void viewLogin() {
    }

    @Test
    void viewAdminHomePage() throws Exception {
     //   mockMvc.perform(get("/admin/home"))

        mockMvc.perform(get("/admin/home"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("totalAmount"))
                .andExpect(view().name("admin/admin_home"));

    }
    // with spring security
    // remove active profile
    // use WithMockUser

    @Test
    void viewUserHomePage() throws Exception {
        ArrayList<ProductDto> productDtos = new ArrayList<>();
        ProductDto productDto = new ProductDto();
        productDto.setProductId(0L);
        productDto.setProductId(0L);
        productDto.setProductName("dummy product");
        productDto.setProductDesc("desc");
        productDto.setProductPrice(0);
        productDto.setProductCategory(new CategoryDto());
        productDto.setCreatedBy("");
        productDto.setUpdatedBy("");
        productDtos.add(productDto);

        when(productService.getAllProducts()).thenReturn(productDtos);
        mockMvc.perform(get("/user/home"))
                .andExpect(model().attributeExists("products"));

    }

    @Test
    void viewDefaultHomePage() {
    }

    @Test
    void viewRegister() throws Exception {
        mockMvc.perform(get("/register")).andExpect(status().isOk());
    }

    @Test
    void viewAddUser() {
    }

    @Test
    void viewAddUserSave() {
    }

    @Test
    void saveStudent() {
    }

    @Test
    void viewAllUser() {
    }

    @Test
    void editUser() {
    }

    @Test
    void viewUpdateUser() {
    }

    @Test
    void saveUpdateUser() {
    }
}