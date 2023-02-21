
package com.serviceops.ecommerce.repository;
import com.serviceops.ecommerce.entities.Product;

import com.serviceops.ecommerce.entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;




public interface ProductRepository extends JpaRepository<Product,Long> {
public SubCategory findByproductSubCategory(Long Id);


}
