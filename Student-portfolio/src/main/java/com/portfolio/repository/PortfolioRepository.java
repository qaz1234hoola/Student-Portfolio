package com.portfolio.repository;

import com.portfolio.model.Portfolio;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository {

    private Map<String, Portfolio> portfolioDB = new HashMap<>();

    public void save(Portfolio portfolio) {
        portfolioDB.put(portfolio.getUserId(), portfolio);
    }

    public Portfolio findByUserId(String userId) {
        return portfolioDB.get(userId);
    }
}