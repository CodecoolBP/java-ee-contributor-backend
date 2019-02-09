package com.codecool.contributor.service.implementation;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.ProjectRepository;
import com.codecool.contributor.service.ProjectStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Stream;

@Component
public class ProjectStorageJpa implements ProjectStorage {

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
        if (baseProject != null) {
            projectRepository.saveAndFlush(editedProject);
            return baseProject;
        }
        return null;
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
