package com.portfolio.util;

public class PasswordHasher {

    public static String hash(String password) {
        return password;
    }

    public static boolean verify(String raw, String hashed) {
        return raw.equals(hashed);
    }
}