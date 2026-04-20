package com.portfolio.service.impl;

import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.service.SearchService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public List<Portfolio> search(String keyword) {
        List<Portfolio> allPortfolios = portfolioRepository.findAll();
        List<Portfolio> result = new ArrayList<>();

        User currentUser = SessionManager.getUser();
        String currentUserId = null;

        if (currentUser != null) {
            currentUserId = currentUser.getId();
        }

        for (Portfolio portfolio : allPortfolios) {
            if (portfolio == null) {
                continue;
            }

            if (portfolio.getBio() == null) {
                continue;
            }

            // Skip current logged-in user's own portfolio
            if (currentUserId != null && portfolio.getUserId().equals(currentUserId)) {
                continue;
            }

            if (portfolio.getBio().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(portfolio);
            }
        }

        return result;
    }
}