package com.portfolio.service;

public interface AuthService {
    boolean login(String email, String password);
    boolean signup(String email, String password);
}