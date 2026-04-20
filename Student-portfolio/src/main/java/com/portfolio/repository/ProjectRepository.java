package com.portfolio.repository;

import com.portfolio.model.Project;
import java.util.List;

public interface ProjectRepository {
    void save(Project project);

    List<Project> findByUserId(String userId);
}