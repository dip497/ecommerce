package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmail(String userEmail);

}
