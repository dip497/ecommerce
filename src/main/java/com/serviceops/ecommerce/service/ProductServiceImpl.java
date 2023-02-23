package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.repository.ProductRepository;
import com.serviceops.ecommerce.repository.SubCategoryRepository;
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
    private SubCategoryRepository subCategoryRepository;

    @Override
    public boolean createProduct(ProductDto product) {
        productRepository.save(new Product(product.getProductName(), product.getProductDesc(), product.getProductPrice(),subCategoryRepository.findById(product.getProductSubCategory().getSubcategoryId()).get()));
        return true;
    }

    @Override
    public ProductDto updateProduct(ProductDto product) {
       Product product1 = productRepository.findById(product.getProductId()).get();
       product1.setProductDesc(product.getProductDesc());
       product1.setProductName(product.getProductName());
       product1.setProductSubCategory(subCategoryRepository.findById(product.getProductSubCategory().getSubcategoryId()).get());
       return product;
    }
    public void deleteByproductSubCategory(Long Id){
        productRepository.deleteByproductSubCategory(Id);
    }

    @Override
    public boolean removeProduct(Long Id) {
        productRepository.deleteById(Id);
        return true;
    }

    @Override
    public ProductDto findProductById(Long Id) {

        Product product = productRepository.findById(Id).get();
        return this.ProductToDto(product);
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productRepository.findAll();
        return products.stream().map(products1 -> ProductToDto(products1)).collect(Collectors.toList());
    }

    @Override
    public SubCategoryDto findProductSubCategory(Long Id) {
        return convertsub(productRepository.findById(Id).get().getProductCategory());
    }

    private SubCategoryDto convertsub(SubCategory subCategory)
    {
        return new SubCategoryDto(subCategory.getSubcategoryId(),subCategory.getSubcategoryName(),convert(subCategory.getCategory()));
    }
    private CategoryDto convert(Category category) {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }
    private ProductDto ProductToDto(Product product)
    {
        return new ProductDto(product.getProductId(),product.getProductName(), product.getProductDesc(),product.getProductPrice(),convertsub(product.getProductCategory()));
    }


}
