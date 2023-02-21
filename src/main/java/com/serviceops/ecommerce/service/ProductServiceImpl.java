package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepositoryDao;

    @Override
    public boolean createProduct(Product product) {
        productRepositoryDao.save(product);
        return true;
    }

    @Override
    public Product updateProduct(Product product) {
       return productRepositoryDao.save(product);
    }

    @Override
    public void removeProduct(Long Id) {
        productRepositoryDao.deleteById(Id);
    }

    @Override
    public Product findProductById(Long Id) {
        return productRepositoryDao.findById(Id).get();
    }

    @Override
    public List<Product> getAllProducts() {
       return productRepositoryDao.findAll();
    }

    @Override
    public SubCategory findProductSubCategory(Long Id) {
        return productRepositoryDao.findProductSubCategory(Id);
    }
}
