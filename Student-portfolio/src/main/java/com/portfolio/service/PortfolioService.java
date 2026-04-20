package com.portfolio.service;

import com.portfolio.model.Portfolio;

public interface PortfolioService {
    void createPortfolio(String bio);

    Portfolio getMyPortfolio();
}