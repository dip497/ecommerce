package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findBycategoryName(String name);
}
