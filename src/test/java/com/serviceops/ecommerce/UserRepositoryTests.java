package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
class UserRepositoryTests {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserRepository userRepository;

	@Test
	@DirtiesContext
	void contextLoads() {
		User saveUser = userRepository.save(new User("dipendra1", "dipendra@gmail.com", "12345678", Role.ADMIN));
		logger.info("user -> {}", userRepository.findById(saveUser.getUserId()).get());


	}

}
