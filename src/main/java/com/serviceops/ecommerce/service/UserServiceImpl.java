package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.SignUpDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean singUp(SignUpDto signUpDto) throws CustomException {
        if (!Helper.isNull(userRepository.findByUserEmail(signUpDto.getEmail()))) {
            throw new CustomException("User already exists");
        }

        String encryptedPassword = hashPassword(signUpDto.getPassword());

        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), encryptedPassword, Role.CUSTOMER);
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    String hashPassword(String password) {
        Argon2PasswordEncoder encoder = new Argon2PasswordEncoder(32, 64, 1, 15 * 1024, 2);
        return encoder.encode(password);
    }

}
