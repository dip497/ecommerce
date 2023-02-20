package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.SignUpDto;

public interface UserService {
    boolean singUp(SignUpDto signUpDto);
}
