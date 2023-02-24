package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.UserService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@AutoConfigureMockMvc
class UserRepositoryMockTest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @MockBean
    UserRepository userRepository;

    @MockBean
    UserService userService;

   @Test
   void dumy(){
       
   }

}
