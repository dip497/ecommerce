package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;

import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.ProductRepository;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean createProduct(ProductDto product) {
        Product product1 = new Product(product.getProductName(), product.getProductDesc(), product.getProductPrice(), categoryRepository.findById(product.getProductCategory().getCategoryId()).get());
        product1.setCreatedBy(product.getCreatedBy());
        productRepository.save(product1);
        return true;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
        Product product1 = productRepository.findById(product.getProductId()).get();
        product1.setProductDesc(product.getProductDesc());
        product1.setProductName(product.getProductName());
        product1.setProductPrice(product.getProductPrice());
        product1.setUpdatedBy(product.getUpdatedBy());
        productRepository.save(product1);
        return product;
    }
//    public void deleteByproductSubCategory(Long Id){
//        productRepository.deleteByproductSubCategory(Id);
//    }

    @Override
    public boolean removeProduct(Long Id) {
        productRepository.deleteById(Id);
        return true;
    }

    @Override
    public ProductDto findProductById(Long Id) {

        Product product = productRepository.findById(Id).get();
        ProductDto productDto = this.ProductToDto(product);
        productDto.setProductId(product.getProductId());

        return productDto;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map(products1 -> ProductToDto(products1)).collect(Collectors.toList());
    }

    @Override
    public CategoryDto findProductCategory(Long Id) {
        return convert(categoryRepository.findById(Id).get());
    }

    @Override
    public List<ProductDto> findByProductCategory(CategoryDto category) {
        return productRepository.findByProductCategory(categoryRepository.findById(category.getCategoryId()).get()).stream().map(
                product -> ProductToDto(product)).collect(Collectors.toList());

    }

    private CategoryDto convert(Category category) {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }
    private ProductDto ProductToDto(Product product)
    {
        ProductDto productDto = new ProductDto(product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), convert(product.getProductCategory()));
        productDto.setCreatedBy(product.getCreatedBy());
        productDto.setUpdatedBy(product.getUpdatedBy());
        return productDto;
    }

}