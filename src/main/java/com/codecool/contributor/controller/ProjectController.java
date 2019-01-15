package com.codecool.contributor.controller;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contributor")
public class ProjectController {

    @Autowired
    private ProjectStorageMem projectStorage;

    @GetMapping(value="/list", produces = "application/json; charset=UTF-8")
    public List<Project> projectList() {
        return projectStorage.getAll().collect(Collectors.toList());
    }

    @GetMapping(value="/project/{id}", produces = "application/json; charset=UTF-8")
    public Project projectById(@PathVariable("id") Integer id) {
        return projectStorage.find(id);
    }


}
