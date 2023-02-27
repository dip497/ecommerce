package com.serviceops.ecommerce.dto.Category;


import com.serviceops.ecommerce.dto.Product.ProductDto;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CategoryDto{
        private Long categoryId;
        private String categoryName;
        private CategoryDto parent;
        private List<CategoryDto> subCategoryList = new ArrayList<>();
        private List<ProductDto> productDtoList = new ArrayList<>();
        private String createdBy;
        private Timestamp createdTime;
        private String updatedBy;
        private Timestamp updatedTime;
        private String parent_categoryname;
         public CategoryDto(){

        }
        public CategoryDto(Long categoryId, String categoryName)
        {
            this.categoryId= categoryId;
            this.categoryName = categoryName;

        }
        public CategoryDto(String categoryName,String parent_categoryname){
            this.categoryName = categoryName;
            this.parent_categoryname=parent_categoryname;
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

        public List<CategoryDto> getSubCategoriesList() {
            return subCategoryList;
        }
        public void setSubCategoriesSet(List<CategoryDto> subCategorySet) {
            this.subCategoryList = subCategorySet;
        }

        public void removeSubCategory(CategoryDto subCategory)
        {
            subCategoryList.remove(subCategory);
        }

        public List<ProductDto> getProductDtoList() {
            return productDtoList;
        }

        public void setProductDtoList(List<ProductDto> productDtoList) {
            this.productDtoList = productDtoList;
        }
        public CategoryDto getParent() {
            return parent;
        }

        public void setParent(CategoryDto parent) {
            this.parent = parent;
        }
        public String getParent_categoryname() {
            return parent_categoryname;
        }
        public void setParent_categoryname(String parent_categoryname){this.parent_categoryname=parent_categoryname;}
        public List<CategoryDto> getSubCategoryList() {
            return subCategoryList;
        }

        public void setSubCategoryList(List<CategoryDto> subCategoryList) {
            this.subCategoryList = subCategoryList;
        }

        public void setCreatedTime(Timestamp createdTime) {
            this.createdTime = createdTime;
        }

          public String getUpdatedBy() {
            return updatedBy;
        }

        public void setUpdatedBy(String updatedBy) {
            this.updatedBy = updatedBy;
        }

        public Timestamp getUpdatedTime() {
            return updatedTime;
        }

        public void setUpdatedTime(Timestamp updatedTime) {
            this.updatedTime = updatedTime;
        }


        public String getCreatedBy() {
            return createdBy;
        }

        public void setCreatedBy(String createdBy) {
            this.createdBy = createdBy;
        }

        public Timestamp getCreatedTime() {
            return createdTime;
        }


        @Override
        public String toString() {
            return "CategoryDto{" +
                    "categoryId=" + categoryId +
                    ", categoryName='" + categoryName + '\'' +
                    ", parent=" + parent +
                    ", subCategoryList=" + subCategoryList +
                    ", productDtoList=" + productDtoList +
                    ", parent_categoryname='" + parent_categoryname + '\'' +
                    '}';
        }
}


