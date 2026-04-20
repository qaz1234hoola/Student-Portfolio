package com.portfolio.repository;

import com.portfolio.model.Project;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

    private final List<Project> projects = new ArrayList<>();

    @Override
    public void save(Project project) {
        projects.add(project);
    }

    @Override
    public List<Project> findByUserId(String userId) {
        List<Project> result = new ArrayList<>();

        for (Project project : projects) {
            if (project.getUserId().equals(userId)) {
                result.add(project);
            }
        }

        return result;
    }
}