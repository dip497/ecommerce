package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.exceptions.CategoryExist;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    CategoryRepository categoryRepositoryDao;
    @Override
    public boolean createCategory(Category category) {
        if(!Helper.isNull(categoryRepositoryDao.findBycategoryName(category.getCategoryName())))
        {
            throw new CategoryExist("Category Already Exist");
        }
        else{
            categoryRepositoryDao.save(category);
            return true;
        }
    }

    @Override
    public List<Category> getAllCategroies() {
        return categoryRepositoryDao.findAll();
    }

    @Override
    public void removeCategoryById(Long Id) {

        categoryRepositoryDao.deleteById(Id);
    }

    @Override
    public Category findCategoryById(Long Id) {
        Optional<Category> category = categoryRepositoryDao.findById(Id);
        return category.get();
    }

    @Override
    public Category updateCategoryById(Category category) {
        return  categoryRepositoryDao.save(category);

    }
}
