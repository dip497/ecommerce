package com.serviceops.ecommerce.utils;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;

public class PasswordHelper {

    static Argon2PasswordEncoder encoder = new Argon2PasswordEncoder();

    private PasswordHelper() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean matchPassword(String password, String passwordToMatch) {

        return encoder.matches(password, hashPassword(passwordToMatch));
    }

    public static String hashPassword(String password) {

        return encoder.encode(password);
    }
}
