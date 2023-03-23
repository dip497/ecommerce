package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.config.CustomUserDetails;
import com.serviceops.ecommerce.dto.user.UserDto;
import com.serviceops.ecommerce.dto.user.UserPasswordDto;
import com.serviceops.ecommerce.entities.User;
import com.serviceops.ecommerce.exceptions.CustomException;
import com.serviceops.ecommerce.repository.CustomRepository;
import com.serviceops.ecommerce.repository.UserRepository;
import com.serviceops.ecommerce.utils.EntityToDto;
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

    @Autowired
    CustomRepository customRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean signUp(UserDto userDto) throws CustomException {
    /*    if (!Helper.isNull(customRepository.findByColumn("userEmail",userDto.getUserEmail(),User.class))) {
            throw new CustomException("User already exists");
        }*/

        String encryptedPassword = PasswordHelper.hashPassword(userDto.getUserPassword());

        User user = new User(userDto.getUserFirstName(), userDto.getUserLastName(), userDto.getUserEmail(), encryptedPassword, userDto.getUserRole());
        user.setCreatedBy(userDto.getCreatedBy());
        try {
            customRepository.save(user);
            logger.info("User saved successfully ->{}",userDto.getUserEmail() + " by " + userDto.getCreatedBy());
            return true;
        } catch (Exception e) {
            logger.error("User failed to save");
            throw new CustomException(e.getMessage());
        }
    }




    @Override
    public UserDto getUser(String email) {
        User user = customRepository.findByColumn("userEmail",email,User.class);
        logger.info("User found->{}", email);

        if (Helper.isNull(user)) {
            logger.error("User not found");
            throw new CustomException("User not exists");
        }

        return entityToDto(user);
    }




    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = customRepository.findAll(User.class);
        if(users.isEmpty()){
            logger.error("Empty List of Users");
        }
        return users.stream().map(this::entityToDto).toList();
    }

    @Override
    public void deleteUser(Long id) {


         customRepository.deleteById(User.class,id,"userId");
         logger.info("User deleted ->{}", id);
    }

    @Override
    public void updateUser(UserDto userDto) {
       User optionalUser =  customRepository.findByColumn("userEmail", userDto.getUserEmail(), User.class);
        if(optionalUser!=null) {
            User user = optionalUser;
            user.setUserFirstName(userDto.getUserFirstName());
            user.setUserLastName(userDto.getUserLastName());
            user.setUserRole(userDto.getUserRole());
            user.setUpdatedBy(userDto.getUpdatedBy());
            customRepository.save(user);
            logger.info("User updated ->{}", userDto.getUserId());
        }else{
            logger.error("user not found");

            throw  new CustomException("user not found");
        }
    }

    @Override
    public boolean updatePassword(UserPasswordDto userPasswordDto) {
        String newEncyptedPassowrd = PasswordHelper.hashPassword(userPasswordDto.getNewPassword());
        User user = customRepository.findByColumn("userEmail", userPasswordDto.getEmail(), User.class);



        if(PasswordHelper.matchPassword(userPasswordDto.getOldPassword(),user.getUserPassword())){
            user.setUserPassword(newEncyptedPassowrd);
            customRepository.save(user);
            logger.info("password updated of ->{} ", userPasswordDto.getEmail());
            return true;
        }
        logger.error("password failed to match");
        return false;
    }

    public UserDto entityToDto(User user){
        UserDto dto =  new UserDto(user.getUserId(), user.getUserFirstName(), user.getUserLastName(), user.getUserEmail(), user.getUserPassword(), user.getUserRole());
        logger.debug("entity to dto converted");
        EntityToDto<User, UserDto> entity = new EntityToDto<>(user, dto);
        return entity.getDto();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =
        // userRepository.findByUserEmail(username);
               customRepository.findByColumn("userEmail",username, User.class);
        if (user == null) {
            logger.error("User not founds ->{}",username);
            throw  new UsernameNotFoundException("No user found for the given email");
        }
        logger.info("User Login ->{}",username);
        return new CustomUserDetails(user);
    }
}
