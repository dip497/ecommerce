package com.serviceops.ecommerce.controller;

import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(controllers = UserController.class)
// MockMvc is automatically configured with necessary filter chain
// @ WebMvcTest will tell spring boot to instantiate only the web layer
//    and not the entire context  becouse of this controller tests that us
//    @WebMvcTest will run faster than with other approches

class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private UserService userService;

/*
 if using SpringBootTest
    @Autowired
    private WebApplicationContext context;

    @BeforeAll
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }
*/
    @BeforeEach
    public void setup(){
        this.mvc = MockMvcBuilders.webAppContextSetup(this.context).apply(springSecurity()).build();
    }

    @Test
    void viewUpdateUser() throws Exception {
        mvc.perform(get("/login"))
                .andExpect(status().isOk());
             //   .andExpect(model().attributeExists("/user/updateUser"))
             //   .andExpect(view().name("/user/updateUser")).;
    }

    @Test
    void updateUserSave() {
    }

    @Test
    void viewUpdatePassword() {
    }

    @Test
    void updatePasswordSave() {
    }
}