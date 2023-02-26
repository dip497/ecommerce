package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.dto.user.UserPasswordDto;
import com.serviceops.ecommerce.entities.Role;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.Helper;
import com.serviceops.ecommerce.utils.PasswordHelper;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Principal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean signUp(UserDto userDto) throws CustomException {
        if (!Helper.isNull(userRepository.findByUserEmail(userDto.getUserEmail()))) {
            throw new CustomException("User already exists");
        }

        String encryptedPassword = PasswordHelper.hashPassword(userDto.getUserPassword());

        User user = new User(userDto.getUserFirstName(), userDto.getUserLastName(), userDto.getUserEmail(), encryptedPassword, userDto.getUserRole());
        user.setCreatedBy(userDto.getCreatedBy());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }




    @Override
    public UserDto getUser(String email) {
        User user = userRepository.findByUserEmail(email);


        if (Helper.isNull(user)) {
            throw new CustomException("User not exists");
        }

        return entityToDto(user);
    }




    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::entityToDto).toList();
    }

    @Override
    public boolean deleteUser(Long id) {


         userRepository.deleteById(id);
         return true;
    }

    @Override
    public boolean updateUser(UserDto userDto) {
        Optional<User> optionalUser =  userRepository.findById(userDto.getUserId());
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserFirstName(userDto.getUserFirstName());
            user.setUserLastName(userDto.getUserLastName());
            user.setUserRole(userDto.getUserRole());
            user.setUpdatedBy(userDto.getUpdatedBy());
            userRepository.save(user);
        }else{
            throw  new CustomException("user not found");
        }
        return true;
    }

    @Override
    public boolean updatePassword(UserPasswordDto userPasswordDto) {
        String newEncyptedPassowrd = PasswordHelper.hashPassword(userPasswordDto.getNewPassword());
        User user = userRepository.findByUserEmail(userPasswordDto.getEmail());



        if(PasswordHelper.matchPassword(userPasswordDto.getOldPassword(),user.getUserPassword())){
            System.out.println("password match");
            user.setUserPassword(newEncyptedPassowrd);
            userRepository.save(user);
          //  userRepository.updatePassword(newEncyptedPassowrd, userPasswordDto.getEmail());
            return true;
        }
        return false;
    }

    private UserDto entityToDto(User user){
        UserDto dto =  new UserDto(user.getUserId(), user.getUserFirstName(), user.getUserLastName(), user.getUserEmail(), user.getUserPassword(), user.getUserRole());
        dto.setUpdatedBy(user.getUpdatedBy());
        dto.setCreatedBy(user.getCreatedBy());
        return dto;
    }



}
