package com.serviceops.ecommerce.repository;


import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
    List<Category> findBysubcategoryName(String name);
    void deleteBysubcategoryName(String name);

    @Modifying
    @Query(value="DELETE FROM sub_category WHERE subcategory_id = ?1", nativeQuery=true)
    public void deleteById(Long a);
}
