package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.exceptions.CategoryExist;
import com.serviceops.ecommerce.repository.SubCategoryRepository;
import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SubCategoryServicempl implements SubCategoryService{

    @Autowired
    SubCategoryRepository subCategoryRepositoryDao;
    @Override
    public boolean createSubCategory(SubCategory subCategory) {
        if(!Helper.isNull(subCategoryRepositoryDao.findByName(subCategory.getSubcategoryName())))
        {
            throw new CategoryExist("Category Already Exist");
        }
        else{
            subCategoryRepositoryDao.save(subCategory);
            return true;
        }
    }

    @Override
    public List<SubCategory> getAllSubCategroies() {
        return subCategoryRepositoryDao.findAll();
    }

    @Override
    public void removeSubCategoryById(Long Id) {

        subCategoryRepositoryDao.deleteById(Id);
    }

    @Override
    public SubCategory findSubCategoryById(Long Id) {
        Optional<SubCategory> subCategories = subCategoryRepositoryDao.findById(Id);
        return subCategories.get();
    }

    @Override
    public SubCategory updateSubCategoryById(SubCategory subCategory) {
        return  subCategoryRepositoryDao.save(subCategory);

    }


}
