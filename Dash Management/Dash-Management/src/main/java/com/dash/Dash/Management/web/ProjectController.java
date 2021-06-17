package com.dash.Dash.Management.web;

import com.dash.Dash.Management.DAO.ProjectRepository;
import com.dash.Dash.Management.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/new")
    public String displayProjectForm(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model){
        projectRepository.save(project);

        return "redirect:/projects/new";
    }

    @GetMapping("/home")
    public String displayHome(Model model){
        List<Project> projects = projectRepository.findAll();
        model.addAttribute("projects", projects);
        return "projects-home";
    }

}
