package com.serviceops.ecommerce.service;

import com.serviceops.ecommerce.dto.Category.CategoryDto;
import com.serviceops.ecommerce.dto.Product.ProductDto;
import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.Category;
import com.serviceops.ecommerce.entities.Product;
import com.serviceops.ecommerce.entities.SubCategory;
import com.serviceops.ecommerce.exceptions.CategoryExist;
import com.serviceops.ecommerce.repository.CategoryRepository;
import com.serviceops.ecommerce.repository.SubCategoryRepository;
import com.serviceops.ecommerce.utils.Helper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class SubCategoryServicempl implements SubCategoryService{

    @Autowired
    private SubCategoryRepository subCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductService productService;
    @Override
    public boolean createSubCategory(SubCategoryDto subCategoryDto) {

          subCategoryRepository.save(dtotosub(subCategoryDto));
            return true;

    }

    @Override
    public List<SubCategoryDto> getAllSubCategroies() {
        List<SubCategory> subCategories = subCategoryRepository.findAll();
        return subCategories.stream().map(subCategory1 -> convertsub(subCategory1)).collect(Collectors.toList());
    }

    @Override
    public void removeSubCategoryById(Long Id) {
        if(subCategoryRepository.findById(Id).get().getProductSet().isEmpty()) {
            subCategoryRepository.deleteById(Id);
        }
        else{
            productService.deleteByproductSubCategory(Id);
            subCategoryRepository.deleteById(Id);
        }
    }

    @Override
    public SubCategoryDto findSubCategoryById(Long Id) {
        SubCategory subCategories = subCategoryRepository.findById(Id).get();
        SubCategoryDto subCategoryDto = convertsub(subCategories);
        subCategoryDto.setProductSet(subCategories.getProductSet().stream().map(product ->ProductToDto(product)).collect(Collectors.toSet()));
        return subCategoryDto;
    }

    @Override
    public SubCategoryDto updateSubCategoryById(SubCategoryDto subCategoryDto) {
//        subCategoryRepository.save(subCategoryDto);
        SubCategory subCategory = subCategoryRepository.findById(subCategoryDto.getSubcategoryId()).get();
        subCategory.setSubcategoryName(subCategoryDto.getSubcategoryName());
        subCategoryRepository.save(subCategory);
        return subCategoryDto;
//

    }
    private SubCategoryDto convertsub(SubCategory subCategory)
    {
        return new SubCategoryDto(subCategory.getSubcategoryId(),subCategory.getSubcategoryName(),convert(subCategory.getCategory()));
    }
    private CategoryDto convert(Category category) {
        return new CategoryDto(category.getCategoryId(), category.getCategoryName());
    }
    private SubCategory dtotosub(SubCategoryDto subCategoryDto)
    {
        return new SubCategory(subCategoryDto.getSubcategoryName(),categoryRepository.findById(subCategoryDto.getCategory().getCategoryId()).get());
    }
    private ProductDto ProductToDto(Product product)
    {
        return new ProductDto(product.getProductId(),product.getProductName(), product.getProductDesc(),product.getProductPrice(),convertsub(product.getProductCategory()));
    }


}
