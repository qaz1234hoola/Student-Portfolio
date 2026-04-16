package com.portfolio.repository;

import com.portfolio.model.User;

public interface UserRepository {
    void save(User user);
    User findByEmail(String email);
}