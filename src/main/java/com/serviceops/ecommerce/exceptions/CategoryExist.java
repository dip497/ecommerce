package com.serviceops.ecommerce.exceptions;

public class CategoryExist extends IllegalArgumentException{
    public CategoryExist(String message){
        super(message);
    }
}
