package com.portfolio.builder;

import com.portfolio.model.Portfolio;
import java.util.UUID;

public class PortfolioBuilder {

    private String userId;
    private String bio;

    public PortfolioBuilder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public PortfolioBuilder setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public Portfolio build() {
        String id = UUID.randomUUID().toString();
        return new Portfolio(id, userId, bio);
    }
}