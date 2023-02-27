package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.entities.Category;

import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.exceptions.CategoryExist;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import java.util.stream.Collectors;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public boolean createCategory(CategoryDto categoryDto) {
        if(!Helper.isNull(categoryRepository.findBycategoryName(categoryDto.getCategoryName())))
        {
            throw new CategoryExist("Category Already Exist");
        }
        else{
            Category category = categoryRepository.findBycategoryName(categoryDto.getParent_categoryname());
            Category category1 = new Category(categoryDto.getCategoryName(), categoryRepository.findBycategoryName(categoryDto.getParent_categoryname()));
            category1.setCreatedBy(categoryDto.getCreatedBy());
            categoryRepository.save(category1);
            return true;
        }
    }

    @Override
    public List<CategoryDto> getAllCategroies() {
        List<Category> category = categoryRepository.findAll();
        return category.stream().map(category1 -> convert(category1)).collect(Collectors.toList());
    }


    @Override
    public void removeCategoryById(Long Id) {
        categoryRepository.deleteById(Id);
    }

    @Override
    public CategoryDto findCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id).get();
        CategoryDto categoryDto = convert(category);
        categoryDto.setProductDtoList(category.getProducts().stream().map(product -> con(product)).collect(Collectors.toList()));
        return categoryDto;
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto) {
        Category category= categoryRepository.findById(categoryDto.getCategoryId()).get();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setUpdatedBy(categoryDto.getUpdatedBy());
        categoryRepository.save(category);
        return categoryDto;

    }

    @Override
    public List<CategoryDto> getAllSubCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id).get();
        List<Category> subCategorySet = category.getSubcategories();
        return subCategorySet.stream().map(subCategory1 -> convert(subCategory1)).collect(Collectors.toList());
    }
    @Override
    public List<CategoryDto> getSubcategories(String categoryName){

        return categoryRepository.findBycategoryName(categoryName).getSubcategories().stream().map(subcategory ->convert(subcategory)).collect(Collectors.toList());
    }
    private CategoryDto convert(Category category)
    {
        CategoryDto categoryDto = new CategoryDto(category.getCategoryId(), category.getCategoryName());
        categoryDto.setCreatedBy(category.getCreatedBy());
        categoryDto.setUpdatedBy(category.getUpdatedBy());
        return categoryDto;
    }
    private ProductDto con(Product product){
        ProductDto productDto = new ProductDto(product.getProductId(), product.getProductName(), product.getProductDesc(), product.getProductPrice(), convert(product.getProductCategory()));
        productDto.setCreatedBy(product.getCreatedBy());
        productDto.setUpdatedBy(product.getUpdatedBy());
        return productDto;
    }

}
