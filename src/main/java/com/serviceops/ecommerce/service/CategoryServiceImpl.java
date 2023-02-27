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
            logger.info("Category Already Exist->{]");
            throw new CategoryExist("Category Already Exist");
        }
        else{
            Category category = categoryRepository.findBycategoryName(categoryDto.getParent_categoryname());
            Category category1 = new Category(categoryDto.getCategoryName(), categoryRepository.findBycategoryName(categoryDto.getParent_categoryname()));
            category1.setCreatedBy(categoryDto.getCreatedBy());
            categoryRepository.save(category1);
            logger.info("Category Created");
            return true;
        }
    }

    @Override
    public List<CategoryDto> getAllCategroies() {
        List<Category> category = categoryRepository.findAll();
        logger.info("List Of Categories");
        return category.stream().map(category1 -> Helper.EntityToDto(category1)).collect(Collectors.toList());
    }


    @Override
    public void removeCategoryById(Long Id) {
        logger.info("Category Deleted Id no."+Id);
        categoryRepository.deleteById(Id);
    }

    @Override
    public CategoryDto findCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id).get();
        CategoryDto categoryDto = Helper.EntityToDto(category);
        categoryDto.setProductDtoList(category.getProducts().stream().map(product -> Helper.EntityToDto(product)).collect(Collectors.toList()));
        logger.info("Category find ->{}",categoryDto);
        return categoryDto;
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto) {
        Category category= categoryRepository.findById(categoryDto.getCategoryId()).get();
        category.setCategoryName(categoryDto.getCategoryName());
        category.setUpdatedBy(categoryDto.getUpdatedBy());
        categoryRepository.save(category);
        logger.info("Updated Catgeory ->{}",category);
        return categoryDto;

    }

    @Override
    public List<CategoryDto> getAllSubCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id).get();
        List<Category> subCategorySet = category.getSubcategories();
        logger.info("Return list of Subcategories");
        return subCategorySet.stream().map(subCategory1 -> Helper.EntityToDto(subCategory1)).collect(Collectors.toList());
    }
    @Override
    public List<CategoryDto> getSubcategories(String categoryName){
    logger.info("Function to convert Categories to Categpry DTO");
        return categoryRepository.findBycategoryName(categoryName).getSubcategories().stream().map(subcategory ->Helper.EntityToDto(subcategory)).collect(Collectors.toList());
    }

}
