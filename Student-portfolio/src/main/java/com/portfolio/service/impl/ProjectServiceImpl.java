package com.portfolio.service.impl;

import com.portfolio.model.Project;
import com.portfolio.model.User;
import com.portfolio.repository.ProjectRepository;
import com.portfolio.service.ProjectService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void addProject(String title, String description) {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return;
        }

        Project project = new Project(
                UUID.randomUUID().toString(),
                title,
                description,
                currentUser.getId());

        projectRepository.save(project);
    }

    @Override
    public List<Project> getMyProjects() {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return new ArrayList<>();
        }

        return projectRepository.findByUserId(currentUser.getId());
    }
}