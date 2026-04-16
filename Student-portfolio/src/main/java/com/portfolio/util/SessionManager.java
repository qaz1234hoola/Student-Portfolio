package com.portfolio.util;

import com.portfolio.model.User;

public class SessionManager {
    private static User currentUser;

    public static void setUser(User user) {
        currentUser = user;
    }

    public static User getUser() {
        return currentUser;
    }
}