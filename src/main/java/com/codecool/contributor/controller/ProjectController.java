package com.codecool.contributor.controller;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/contributorapi")
public class ProjectController {

    @Autowired
    private ProjectStorageMem projectStorage;

    @GetMapping(value="/list")
    public List<Project> projectList() {
        return projectStorage.getAll().collect(Collectors.toList());
    }

    @GetMapping(value="/list/filter")
    public List<Project> projectListFiltered(@RequestParam(value = "status", required = false) String status,
                                             @RequestParam(value = "tag", required = false) List<String> tags) {
        return projectStorage.getBy(status, tags).collect(Collectors.toList());
    }

    @GetMapping(value="/project/{id}")
    public List<Project> projectById(@PathVariable("id") Integer id) {
        List<Project> returnList = new ArrayList<>();
        returnList.add(projectStorage.find(id));
        return returnList;
    }

    @PostMapping("/project/add")
    public List<Project> addProject(@RequestBody @Valid Project project) {
        this.projectStorage.add(project);
        List<Project> returnList = new ArrayList<>();
        returnList.add(project);
        return returnList;
    }

    @DeleteMapping(value="/project/{id}/delete")
    public String deleteProjectById(@PathVariable("id") Integer id) {
        this.projectStorage.remove(id);
        return "Success.";
    }
}
