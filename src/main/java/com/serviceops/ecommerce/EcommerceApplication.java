package com.serviceops.ecommerce;

import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(EcommerceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	userRepository.save(new User("dipendra","dipendra@gmail.com","12345678", Role.ADMIN));
//        userRepository.deleteById(2L);
    }
}
