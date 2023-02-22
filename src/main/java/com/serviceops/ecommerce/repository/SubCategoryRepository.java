package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<Category> findBysubcategoryName(String name);
    void deleteBysubcategoryName(String name);
}
