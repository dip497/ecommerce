package com.serviceops.ecommerce.exceptions;

public class OrderNotFoundException extends IllegalArgumentException{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}
