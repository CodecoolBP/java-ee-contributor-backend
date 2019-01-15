package com.codecool.contributor.controller;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contributor")
public class ProjectController {

    @Autowired
    private ProjectStorageMem projectStorage;

    @GetMapping(value="/list")
    public List<Project> projectList() {
        return projectStorage.getAll().collect(Collectors.toList());
    }

    @GetMapping(value="/project/{id}")
    public Project projectById(@PathVariable("id") Integer id) {
        return projectStorage.find(id);
    }

    @PostMapping("/project/add")
    public Project addProject(@RequestBody @Valid Project project) {
        this.projectStorage.add(project);
        return project;
    }

    @DeleteMapping(value="/project/{id}/delete")
    public String deleteProjectById(@PathVariable("id") Integer id) {
        this.projectStorage.remove(id);
        return "Success.";
    }
}
