package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.SignInDto;
import com.serviceops.ecommerce.dto.user.SignUpDto;

public interface UserService {
    boolean signUp(SignUpDto signUpDto);

    boolean signIn(SignInDto signInDto);
}
