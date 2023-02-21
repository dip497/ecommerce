package com.serviceops.ecommerce.utils;

import com.serviceops.ecommerce.entities.Role;

public class Helper {
    private Helper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isNull(Object obj) {
        return obj == null;
    }

    public static Role getRole(String role) {
        if (role.equals(Role.CUSTOMER.toString())) {
            return Role.CUSTOMER;
        } else {
            return Role.ADMIN;
        }
    }
}
