package com.serviceops.ecommerce.dto.Product;


import com.serviceops.ecommerce.dto.SubCategory.SubCategoryDto;
import com.serviceops.ecommerce.entities.SubCategory;

public class ProductDto {


    private long productId;

    private String productName;

    private String productDesc;
    private int productPrice;
    private SubCategoryDto productSubCategory;

    public ProductDto(){

    }
    public ProductDto(Long productId,String productName, String productDesc, int productPrice, SubCategoryDto productSubCategory) {
        this.productId=productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productSubCategory = productSubCategory;
    }
    public void setProductId(Long productId){this.productId=productId;}
    public long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public SubCategoryDto getProductSubCategory() {
        return productSubCategory;
    }
    public void setProductSubCategory(SubCategoryDto productSubCategory) {
        this.productSubCategory = productSubCategory;
    }
    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productSubCategory=" + productSubCategory +
                ",productSubCategoryId="+this.getProductSubCategory().getSubcategoryId()+
                '}';
    }








}
