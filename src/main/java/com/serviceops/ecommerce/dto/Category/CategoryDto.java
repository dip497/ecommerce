package com.serviceops.ecommerce.dto.Category;


import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto{
        private Long categoryId;
        private String categoryName;

        private Set<SubCategoryDto> subCategorySet = new HashSet<>();
        public CategoryDto(){

        }
        public CategoryDto(Long categoryId, String categoryName)
        {
            this.categoryId= categoryId;
            this.categoryName = categoryName;

        }
        public Long getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Long categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public Set<SubCategoryDto> getSubCategoriesSet() {
            return subCategorySet;
        }
        public void setSubCategoriesSet(Set<SubCategoryDto> subCategorySet) {
            this.subCategorySet = subCategorySet;
        }
        public Set<SubCategoryDto> getSubCategorySet() {
            return subCategorySet;
        }
        public void addSubCategory(SubCategoryDto subCategory)
        {
            subCategorySet.add(subCategory);
        }
        public void removeSubCategory(SubCategoryDto subCategory)
        {
            subCategorySet.remove(subCategory);
        }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }


    }


