package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    User findByUserEmail(String userEmail);

}
