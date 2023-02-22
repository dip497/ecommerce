package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.SignInDto;
import com.serviceops.ecommerce.dto.user.SignUpDto;
import com.serviceops.ecommerce.entities.User;

public interface UserService {
    boolean signUp(SignUpDto signUpDto);

    boolean signIn(SignInDto signInDto);
    User getUser(String email);
}
