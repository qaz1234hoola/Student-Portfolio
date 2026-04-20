package com.portfolio.controller;

import com.portfolio.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String email,
            @RequestParam String password) {

        boolean success = authService.signup(email, password);

        if (success) {
            return "login";
        }
        return "signup";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email,
            @RequestParam String password) {

        boolean success = authService.login(email, password);

        if (success) {
            return "redirect:/dashboard";
        }
        return "login";
    
}