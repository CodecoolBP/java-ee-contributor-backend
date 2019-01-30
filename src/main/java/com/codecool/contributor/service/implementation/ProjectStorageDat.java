package com.codecool.contributor.service.implementation;


import com.codecool.contributor.entity.Project;
import com.codecool.contributor.repository.ProjectRepository;
import com.codecool.contributor.repository.UserRepository;
import com.codecool.contributor.service.ProjectStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProjectStorageDat implements ProjectStorage {

    @Autowired
    private com.codecool.contributor.repository.ProjectRepository ProjectRepository;

    @Autowired
    private com.codecool.contributor.repository.UserRepository UserRepository;

    @Override
    public void add(Project project) {
        ProjectRepository.save(project);
    }

    @Override
    public Project find(int id) {
        return ProjectRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        ProjectRepository.deleteById(id);
    }

    @Override
    public Project edit(Project editedProject) {
        Project baseProject = ProjectRepository.findById(editedProject.getId()).orElse(null);
        baseProject.setTitle(editedProject.getTitle());
        baseProject.setDescription(editedProject.getDescription());
        baseProject.setShortDesc(editedProject.getShortDesc());
        baseProject.setOrganisation(editedProject.getOrganisation());
        baseProject.setRequirements(editedProject.getRequirements());
        baseProject.setTags(editedProject.getTags());
        baseProject.setStatus(editedProject.getStatus());
        ProjectRepository.saveAndFlush(baseProject);
        return ProjectRepository.findById(baseProject.getId()).orElse(null);
    }

    @Override
    public Stream<Project> getAll() {
        List<Project> data = ProjectRepository.findAll();
        return data.stream();
    }

    @Override
    public Stream<Project> getBy(String status) {
        List<Project> data = ProjectRepository.findAll();
        return data.stream().filter(p -> p.getStatus().toString().equals(status));
    }

    @Override
    public Stream<Project> getBy(List<String> compareTags) {
        List<Project> data = ProjectRepository.findAll();
        return data.stream().filter(p -> p.tagsContainCompareTag(compareTags));
    }

}
