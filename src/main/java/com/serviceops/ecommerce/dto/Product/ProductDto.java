package com.serviceops.ecommerce.dto.Product;


import com.serviceops.ecommerce.dto.Category.CategoryDto;

public class ProductDto {


    private long productId;

    private String productName;

    private String productDesc;
    private int productPrice;
    private CategoryDto productCategory;

    public ProductDto(){

    }
    public ProductDto(String productName, String productDesc, int productPrice, CategoryDto productCategory) {

        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
    }
    public ProductDto(Long productId,String productName, String productDesc, int productPrice, CategoryDto productCategory) {
        this.productId=productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
        this.productCategory = productCategory;
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

    public CategoryDto getProductCategory() {
        return productCategory;
    }
    public void setProductCategory(CategoryDto productCategory) {
        this.productCategory = productCategory;
    }
    @Override
    public String toString() {
        return "ProductDto{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDesc='" + productDesc + '\'' +
                ", productPrice=" + productPrice +
                ", productSubCategory=" + productCategory +

                '}';
    }








}
