package com.portfolio.controller;

import com.portfolio.model.Project;
import com.portfolio.model.User;
import com.portfolio.service.ProjectService;
import com.portfolio.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return "redirect:/login";
        }

        List<Project> projects = projectService.getMyProjects();
        model.addAttribute("projects", projects);
        model.addAttribute("userEmail", currentUser.getEmail());

        return "dashboard";
    }

    @PostMapping("/projects/add")
    public String addProject(@RequestParam String title,
            @RequestParam String description) {

        User currentUser = SessionManager.getUser();

        if (currentUser == null) {
            return "redirect:/login";
        }

        projectService.addProject(title, description);
        return "redirect:/dashboard";
    }
}