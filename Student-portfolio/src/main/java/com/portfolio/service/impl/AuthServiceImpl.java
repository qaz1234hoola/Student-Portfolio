package com.portfolio.service.impl;

import com.portfolio.factory.UserFactory;
import com.portfolio.model.User;
import com.portfolio.repository.UserRepository;
import com.portfolio.service.AuthService;
import com.portfolio.util.PasswordHasher;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean signup(String email, String password) {
        User existingUser = userRepository.findByEmail(email);

        if (existingUser != null) {
            return false; // user already exists
        }

        User user = UserFactory.createUser(email, password);
        userRepository.save(user);
        return true;
    }

    @Override
    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return false;
        }

        boolean valid = PasswordHasher.verify(password, user.getPassword());

        if (valid) {
            SessionManager.setUser(user);
        }

        return valid;
    }
}