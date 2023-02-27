package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.config.CustomUserDetails;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.dto.user.UserPasswordDto;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.Helper;
import com.serviceops.ecommerce.utils.PasswordHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

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
            logger.info("User saved successfully ->{}",userDto.getUserEmail() + " by " + userDto.getCreatedBy());
            return true;
        } catch (Exception e) {
            logger.error("User failed to save");
            throw new CustomException(e.getMessage());
        }
    }




    @Override
    public UserDto getUser(String email) {
        User user = userRepository.findByUserEmail(email);
        logger.info("User found->{}", email);

        if (Helper.isNull(user)) {
            logger.error("User not found");
            throw new CustomException("User not exists");
        }

        return entityToDto(user);
    }




    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            logger.error("Empty List of Users");
        }
        return users.stream().map(this::entityToDto).toList();
    }

    @Override
    public void deleteUser(Long id) {


         userRepository.deleteById(id);
         logger.info("User deleted ->{}", id);
    }

    @Override
    public void updateUser(UserDto userDto) {
        Optional<User> optionalUser =  userRepository.findById(userDto.getUserId());
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUserFirstName(userDto.getUserFirstName());
            user.setUserLastName(userDto.getUserLastName());
            user.setUserRole(userDto.getUserRole());
            user.setUpdatedBy(userDto.getUpdatedBy());
            userRepository.save(user);
            logger.info("User updated ->{}", userDto.getUserId());
        }else{
            logger.error("user not found");

            throw  new CustomException("user not found");
        }
    }

    @Override
    public boolean updatePassword(UserPasswordDto userPasswordDto) {
        String newEncyptedPassowrd = PasswordHelper.hashPassword(userPasswordDto.getNewPassword());
        User user = userRepository.findByUserEmail(userPasswordDto.getEmail());



        if(PasswordHelper.matchPassword(userPasswordDto.getOldPassword(),user.getUserPassword())){
            user.setUserPassword(newEncyptedPassowrd);
            userRepository.save(user);
            logger.info("password updated of ->{} ", userPasswordDto.getEmail());
            return true;
        }
        logger.error("password failed to match");
        return false;
    }

    private UserDto entityToDto(User user){
        UserDto dto =  new UserDto(user.getUserId(), user.getUserFirstName(), user.getUserLastName(), user.getUserEmail(), user.getUserPassword(), user.getUserRole());
        dto.setUpdatedBy(user.getUpdatedBy());
        dto.setCreatedBy(user.getCreatedBy());
        logger.debug("entity to dto converted");
        return dto;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserEmail(username);
        if (user == null) {
            logger.error("User not founds ->{}",username);
            throw  new UsernameNotFoundException("No user found for the given email");
        }
        logger.info("User Login ->{}",username);
        return new CustomUserDetails(user);
    }
}
