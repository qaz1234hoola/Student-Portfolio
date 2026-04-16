package com.portfolio.service;

import com.portfolio.model.Portfolio;
import java.util.List;

public interface SearchService {
    List<Portfolio> search(String keyword);
}