package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class UserRepositoryTests {
	@Autowired
	UserRepository userRepository;

	@Test
	@DirtiesContext
	void contextLoads() {
		userRepository.save(new User("dipendra1","dipendra@gmail.com","12345678", Role.ADMIN));

	}

}
