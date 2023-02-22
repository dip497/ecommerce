package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.Helper;
import com.serviceops.ecommerce.utils.PasswordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean signUp(UserDto signUpDto) throws CustomException {
        if (!Helper.isNull(userRepository.findByUserEmail(signUpDto.getUserEmail()))) {
            throw new CustomException("User already exists");
        }

        String encryptedPassword = PasswordHelper.hashPassword(signUpDto.getUserPassword());

        User user = new User(signUpDto.getUserFirstName(), signUpDto.getUserLastName(), signUpDto.getUserEmail(), encryptedPassword, signUpDto.getUserRole());
        try {
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }

    @Override
    public boolean signIn(UserDto signInDto) {
        User user = userRepository.findByUserEmail(signInDto.getUserEmail());
        if (Helper.isNull(user)) {
            throw new CustomException("User not exists");
        } else if (!PasswordHelper.matchPassword(user.getUserPassword(), signInDto.getUserPassword())) {
            throw new CustomException("Password does not match");

        }
        return true;
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
            userRepository.save(user);
        }else{
            throw  new CustomException("user not found");
        }
        return true;
    }

    private UserDto entityToDto(User user){
        return new UserDto(user.getUserId(), user.getUserFirstName(), user.getUserLastName(), user.getUserEmail(), user.getUserPassword(), user.getUserRole());
    }



}
