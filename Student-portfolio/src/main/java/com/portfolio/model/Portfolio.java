package com.portfolio.model;

public class Portfolio {
    private String id;
    private String userId;
    private String bio;

    public Portfolio() {}

    public Portfolio(String id, String userId, String bio) {
        this.id = id;
        this.userId = userId;
        this.bio = bio;
    }

    public String getId() { return id; }
    public String getUserId() { return userId; }
    public String getBio() { return bio; }

    public void setId(String id) { this.id = id; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setBio(String bio) { this.bio = bio; }
}