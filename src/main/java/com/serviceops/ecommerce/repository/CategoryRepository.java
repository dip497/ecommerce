package com.serviceops.ecommerce.repository;

import com.serviceops.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findBycategoryName(String name);


    @Query(value="SELECT * FROM category WHERE parent_category_id IS NULL ", nativeQuery=true)
    List<Category> findAll();
}
