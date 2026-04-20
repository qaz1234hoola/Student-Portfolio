package com.portfolio.model;

public class Portfolio {
    private String userId;
    private String bio;

    public Portfolio() {
    }

    public Portfolio(String userId, String bio) {
        this.userId = userId;
        this.bio = bio;
    }

    public String getUserId() {
        return userId;
    }

    public String getBio() {
        return bio;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}