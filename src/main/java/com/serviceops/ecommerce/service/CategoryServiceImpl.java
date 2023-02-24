package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.SubCategory;
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
            categoryRepository.save(new Category(categoryDto.getCategoryName()));
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
        Optional<Category> category = categoryRepository.findById(Id);
        CategoryDto categoryDto = new CategoryDto(category.get().getCategoryId(),category.get().getCategoryName());
        categoryDto.setSubCategoriesSet(category.get().getSubCategorySet().stream().map(subCategory -> convertsub(subCategory)).collect(Collectors.toSet()));
        System.out.println("serive dtp "+ categoryDto);
        return categoryDto;
    }

    @Override
    public CategoryDto updateCategoryById(CategoryDto categoryDto) {
        Category category= categoryRepository.findById(categoryDto.getCategoryId()).get();
        category.setCategoryName(categoryDto.getCategoryName());
        categoryRepository.save(category);
        return categoryDto;

    }

    @Override
    public List<SubCategoryDto> getAllSubCategoryById(Long Id) {
        Category category = categoryRepository.findById(Id).get();
        Set<SubCategory> subCategorySet = category.getSubCategorySet();
        return subCategorySet.stream().map(subCategory1 -> convertsub(subCategory1)).collect(Collectors.toList());
    }
    private CategoryDto convert(Category category)
    {
        return new CategoryDto(category.getCategoryId(),category.getCategoryName());
    }
    private SubCategoryDto convertsub(SubCategory subCategory)
    {
        return new SubCategoryDto(subCategory.getSubcategoryId(), subCategory.getSubcategoryName(),this.convert(subCategory.getCategory()));
    }

}
