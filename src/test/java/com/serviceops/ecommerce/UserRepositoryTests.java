package com.serviceops.ecommerce;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.dto.user.UserPasswordDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.service.UserService;
import com.serviceops.ecommerce.utils.PasswordHelper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserRepositoryTests {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    @Test
    void TestFindUserByEmail() {
        User saveUser = userRepository.save(new User("dipendra", "sharma", "rohan@gmail.com", "12345678", Role.ADMIN));
        logger.info("user -> {}", userRepository.findByUserEmail("rohan@gmail.com"));
    }

    @Test
    void TestUserService(){
        UserDto user =new UserDto();
        user.setUserFirstName("user");
        user.setUserLastName("service");
        user.setUserEmail("passwordC@gmail.com");
        user.setUserPassword("test");
        user.setUserRole(Role.CUSTOMER);

        logger.info("user -> {}",   userService.signUp(user));

    }

    @Test
    void updatePassword(){
        UserPasswordDto userPasswordDto = new UserPasswordDto("passwordC@gmail.com","test","1234");
        System.out.println(PasswordHelper.matchPassword(userPasswordDto.getOldPassword(),userService.getUser(userPasswordDto.getEmail()).getUserPassword()));
        userService.updatePassword(userPasswordDto);
    }

}
