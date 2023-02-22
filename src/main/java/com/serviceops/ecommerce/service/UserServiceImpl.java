package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.SignInDto;
import com.serviceops.ecommerce.dto.user.SignUpDto;
import com.serviceops.ecommerce.dto.user.UserRole;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.Helper;
import com.serviceops.ecommerce.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean signUp(SignUpDto signUpDto) throws CustomException {
        if (!Helper.isNull(userRepository.findByUserEmail(signUpDto.getEmail()))) {
            throw new CustomException("User already exists");
        }

        String encryptedPassword = PasswordHelper.hashPassword(signUpDto.getPassword());

        User user = new User(signUpDto.getFirstName(), signUpDto.getLastName(), signUpDto.getEmail(), encryptedPassword, Helper.getRole(signUpDto.getRole()));
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public boolean signIn(SignInDto signInDto) {
        User user = userRepository.findByUserEmail(signInDto.getEmail());
        if (Helper.isNull(user)) {
            throw new CustomException("User not exists");
        } else if (!PasswordHelper.matchPassword(user.getUserPassword(), signInDto.getPassword())) {
            throw new CustomException("Password does not match");

        }
        return true;
    }

    @Override
    public User getUser(String email) {
        User user = userRepository.findByUserEmail(email);
        if (Helper.isNull(user)) {
            throw new CustomException("User not exists");
        }
        return user;
    }

    public boolean canCrud(UserRole userRole) {
        User user = userRepository.findByUserEmail(userRole.getEmail());
        return user.getUserRole() == Role.ADMIN;
    }

}
