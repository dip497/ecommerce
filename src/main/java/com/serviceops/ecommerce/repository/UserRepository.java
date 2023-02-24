package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);

    @Query(value = "update user set user_password= ?1 where user_id=?2",nativeQuery = true)
    void updatePassword(String password,String userEmail);
}
