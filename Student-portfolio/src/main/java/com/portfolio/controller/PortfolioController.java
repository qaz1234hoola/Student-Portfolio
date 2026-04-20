package com.portfolio.controller;

import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import com.portfolio.service.PortfolioService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/portfolio")
    public String portfolioPage(Model model) {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return "redirect:/login";
        }

        Portfolio portfolio = portfolioService.getMyPortfolio();

        if (portfolio == null) {
            portfolio = new Portfolio(currentUser.getId(), "");
        }

        model.addAttribute("portfolio", portfolio);
        model.addAttribute("userEmail", currentUser.getEmail());

        return "portfolio";
    }

    @PostMapping("/portfolio/save")
    public String savePortfolio(@RequestParam String bio) {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return "redirect:/login";
        }

        portfolioService.createPortfolio(bio);
        return "redirect:/portfolio";
    }
}