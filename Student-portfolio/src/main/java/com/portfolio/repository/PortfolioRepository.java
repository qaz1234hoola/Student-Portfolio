package com.portfolio.repository;

import com.portfolio.model.Portfolio;
import java.util.List;

public interface PortfolioRepository {
    void save(Portfolio portfolio);
    Portfolio findByUserId(String userId);
    List<Portfolio> findAll();
}