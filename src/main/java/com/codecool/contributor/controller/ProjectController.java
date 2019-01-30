package com.codecool.contributor.controller;

import com.codecool.contributor.entity.Project;
import com.codecool.contributor.service.implementation.ProjectStorageDat;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value={"/api", "/"})
public class ProjectController {

    @Autowired
    private ProjectStorageDat projectStorage;

    @GetMapping(value={"/projects", ""})
    public List<Project> projectList() {
        return projectStorage.getAll().collect(Collectors.toList());
    }

    @GetMapping(value="/projects/filter")
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
    public List<Project> addProject(@RequestBody Project project) {
        this.projectStorage.add(project);
        List<Project> returnList = new ArrayList<>();
        returnList.add(project);
        return returnList;
    }

    @DeleteMapping(value="/project/{id}")
    public String deleteProjectById(@PathVariable("id") Integer id) {
        this.projectStorage.remove(id);
        return "Success.";
    }

    @PutMapping(value="/project/{id}")
    public List<Project> editProjectById(@PathVariable("id") Integer id, @RequestBody Project editedProject) {
        if (id.equals(editedProject.getId())) {
            Project returnedProject = this.projectStorage.edit(editedProject);
            List<Project> returnList = new ArrayList<>();
            returnList.add(returnedProject);
            return returnList;
        }
        return new ArrayList<>();
    }
}
