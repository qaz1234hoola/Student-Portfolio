package com.portfolio.controller;

import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import com.portfolio.service.SearchService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping("/search")
    public String searchPage(@RequestParam(value = "keyword", required = false) String keyword,
            Model model) {

        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return "redirect:/login";
        }

        List<Portfolio> results = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            results = searchService.search(keyword);
        }

        model.addAttribute("keyword", keyword);
        model.addAttribute("results", results);
        model.addAttribute("userEmail", currentUser.getEmail());

        return "search";
    }
}