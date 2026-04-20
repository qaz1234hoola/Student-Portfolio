package com.portfolio.repository;

import com.portfolio.model.Portfolio;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PortfolioRepositoryImpl implements PortfolioRepository {

    private final List<Portfolio> portfolios = new ArrayList<>();

    @Override
    public void save(Portfolio portfolio) {
        Portfolio existing = findByUserId(portfolio.getUserId());

        if (existing != null) {
            existing.setBio(portfolio.getBio());
        } else {
            portfolios.add(portfolio);
        }
    }

    @Override
    public Portfolio findByUserId(String userId) {
        for (Portfolio portfolio : portfolios) {
            if (portfolio.getUserId().equals(userId)) {
                return portfolio;
            }
        }
        return null;
    }

    @Override
    public List<Portfolio> findAll() {
        return portfolios;
    }
}