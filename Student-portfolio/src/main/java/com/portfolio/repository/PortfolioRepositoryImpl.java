package com.portfolio.repository;

import com.portfolio.config.DatabaseConfig;
import com.portfolio.model.Portfolio;

import java.sql.*;
import java.util.*;

public class PortfolioRepositoryImpl implements PortfolioRepository {

    public void save(Portfolio portfolio) {
        try {
            Connection conn = DatabaseConfig.getConnection();

            String sql = "INSERT INTO portfolios (id, user_id, bio) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, portfolio.getId());
            stmt.setString(2, portfolio.getUserId());
            stmt.setString(3, portfolio.getBio());

            stmt.executeUpdate();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Portfolio findByUserId(String userId) {
        try {
            Connection conn = DatabaseConfig.getConnection();

            String sql = "SELECT * FROM portfolios WHERE user_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, userId);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Portfolio p = new Portfolio(
                        rs.getString("id"),
                        rs.getString("user_id"),
                        rs.getString("bio")
                );
                conn.close();
                return p;
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Portfolio> findAll() {
        List<Portfolio> list = new ArrayList<>();

        try {
            Connection conn = DatabaseConfig.getConnection();

            String sql = "SELECT * FROM portfolios";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                list.add(new Portfolio(
                        rs.getString("id"),
                        rs.getString("user_id"),
                        rs.getString("bio")
                ));
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}