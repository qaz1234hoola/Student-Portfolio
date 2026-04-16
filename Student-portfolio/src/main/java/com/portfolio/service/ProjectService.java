package com.portfolio.service;

import com.portfolio.model.Project;
import java.util.List;

public interface ProjectService {
    void addProject(String title, String description);
    List<Project> getMyProjects();
}