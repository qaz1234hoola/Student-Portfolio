package com.portfolio.service.impl;

import com.portfolio.model.Portfolio;
import com.portfolio.model.User;
import com.portfolio.repository.PortfolioRepository;
import com.portfolio.service.PortfolioService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Override
    public void createPortfolio(String bio) {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return;
        }

        Portfolio portfolio = new Portfolio(currentUser.getId(), bio);
        portfolioRepository.save(portfolio);
    }

    @Override
    public Portfolio getMyPortfolio() {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return null;
        }

        return portfolioRepository.findByUserId(currentUser.getId());
    }
}