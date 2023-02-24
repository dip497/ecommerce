
package com.serviceops.ecommerce.repository;
import com.serviceops.ecommerce.entities.Product;

import com.serviceops.ecommerce.entities.Review;
import com.serviceops.ecommerce.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
public SubCategory findByproductSubCategory(Long Id);

@Modifying
@Query(value="DELETE FROM product WHERE product_sub_category_subcategory_id = ?1", nativeQuery=true)
public void deleteByproductSubCategory(Long Id);
@Modifying @Query(value="DELETE FROM product WHERE product_id = ?1", nativeQuery=true)
public void deleteById(Long Id);

}
