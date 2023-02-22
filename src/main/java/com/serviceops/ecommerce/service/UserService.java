package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;

import java.util.List;

public interface UserService {
    boolean signUp(UserDto userDto);

    boolean signIn(UserDto userDto);
    UserDto getUser(String email);

    List<UserDto> getAllUsers();

    boolean deleteUser(Long id);

    boolean updateUser(UserDto user);


}
