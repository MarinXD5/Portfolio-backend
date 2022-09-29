package com.example.Portfolio.controllers;

import com.example.Portfolio.entities.projects.ProjectsDTO;
import com.example.Portfolio.services.ProjectService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(path = "/list")
public class ProjectControllers {

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/projects/{projectName}")
    public Set<ProjectsDTO> getProjectsByTitle(@PathVariable String projectName){
        return ProjectService.getProjectsByTitle(projectName);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping(path = "/projects")
    public Set<ProjectsDTO> getAllProjects(){
        return ProjectService.getAllProjects();
    }
}
