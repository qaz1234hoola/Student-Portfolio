package com.portfolio.factory;

import com.portfolio.model.User;
import com.portfolio.util.PasswordHasher;

import java.util.UUID;

public class UserFactory {

    public static User createUser(String email, String password) {
        String id = UUID.randomUUID().toString();
        String hashedPassword = PasswordHasher.hash(password);
        return new User(id, email, hashedPassword);
    }
}