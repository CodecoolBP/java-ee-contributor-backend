package com.codecool.contributor.controller;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.model.User;
import com.codecool.contributor.service.ProjectStorage;
import com.codecool.contributor.utility.JwtDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping(value={"/api", "/"})
public class ProjectController {

    @Autowired
    private ProjectStorage projectStorage;

    @Autowired
    private HttpServletRequest request;

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
    public Project projectById(@PathVariable("id") Integer id) {
        Project project = projectStorage.find(id);
        projectStorage.increaseViewCounter(project);
        return project;
    }

    @PostMapping("/project/add")
    public Project addProject(@RequestBody Project project) {
        this.projectStorage.add(project);
        return project;
    }

    @DeleteMapping(value="/project/{id}")
    public String deleteProjectById(@PathVariable("id") Integer id) throws IOException {
        String idToken = request.getHeader("idToken");
        HashMap claimsMap = JwtDecoder.jwtDecode(idToken);
        String userEmail = claimsMap.get("email").toString();
        if (userEmail.equals(projectStorage.find(id).getProjectOwner().getEmail())) {
            this.projectStorage.remove(id);
            return "Success.";
        } else {
            return "Wrong User.";
        }
    }

    @PutMapping(value="/project/{id}/contribute")
    public String contributeProjectById(@PathVariable("id") Integer id, @RequestBody User currentUser) throws IOException {
        Project projectContributed = projectStorage.find(id);
        if (!projectContributed.getProjectOwner().getEmail().equals(currentUser.getEmail())) {
            projectContributed.getContributors().add(currentUser);
            projectStorage.edit(projectContributed);
            return "Success.";
        } else {
            return "You cannot contribute your own project.";
        }
    }

    @PutMapping(value="/project/{id}")
    public String editProjectById(@PathVariable("id") Integer id, @RequestBody Project editedProject) throws IOException {
        String idToken = request.getHeader("idToken");
        HashMap claimsMap = JwtDecoder.jwtDecode(idToken);
        String userEmail = claimsMap.get("email").toString();
        if (id.equals(editedProject.getId()) && userEmail.equals(projectStorage.find(id).getProjectOwner().getEmail())) {
            this.projectStorage.edit(editedProject);
            return "Success.";
        } else {
            return "Wrong User.";
    }
}}
