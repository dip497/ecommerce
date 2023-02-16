
package com.serviceops.ecommerce.repository;
import com.serviceops.ecommerce.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;




public interface ProductRepository extends JpaRepository<Product,Long> {



}
