package com.serviceops.ecommerce.utils;

public class Helper {
    private Helper(){
        throw new IllegalStateException("Utility class");
    }
    public static boolean isNull(Object obj) {
        return obj == null;
    }
}
