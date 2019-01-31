package com.codecool.contributor.service.implementation;


import com.codecool.contributor.entity.Project;
import com.codecool.contributor.repository.ProjectRepository;
import com.codecool.contributor.service.ProjectStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class ProjectStorageDat implements ProjectStorage {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void add(Project project) {
        projectRepository.save(project);
    }

    @Override
    public Project find(int id) {
        return projectRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public Project edit(Project editedProject) {
        Project baseProject = projectRepository.findById(editedProject.getId()).orElse(null);
        baseProject.setTitle(editedProject.getTitle());
        baseProject.setDescription(editedProject.getDescription());
        baseProject.setShortDesc(editedProject.getShortDesc());
        baseProject.setOrganisation(editedProject.getOrganisation());
        baseProject.setRequirements(editedProject.getRequirements());
        baseProject.setTags(editedProject.getTags());
        baseProject.setStatus(editedProject.getStatus());
        projectRepository.saveAndFlush(baseProject);
        return projectRepository.findById(baseProject.getId()).orElse(null);
    }

    @Override
    public Stream<Project> getAll() {
        List<Project> data = projectRepository.findAll();
        return data.stream();
    }

    @Override
    public Stream<Project> getBy(String status) {
        List<Project> data = projectRepository.findAll();
        return data.stream().filter(p -> p.getStatus().toString().equals(status));
    }

    @Override
    public Stream<Project> getBy(List<String> compareTags) {
        List<Project> data = projectRepository.findAll();
        return data.stream().filter(p -> p.tagsContainCompareTag(compareTags));
    }

}
