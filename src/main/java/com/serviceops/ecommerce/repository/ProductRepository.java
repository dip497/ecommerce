
package com.serviceops.ecommerce.repository;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
//public Category findByproductSubCategory(Long Id);

//@Modifying
//@Query(value="DELETE FROM product WHERE product_sub_category_subcategory_id = ?1", nativeQuery=true)
//public void deleteByproductSubCategory(Long Id);

@Modifying
@Query(value="DELETE FROM product WHERE product_id = ?1", nativeQuery=true)
void deleteById(Long Id);




    List<Product> findByProductCategory(Category category);

}
