package com.codecool.contributor.service.implementation;


import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.ProjectStorage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProjectStorageMem implements ProjectStorage {

    private List<Project> data = new ArrayList<>();

    @Override
    public void add(Project project) {
        project.setId(data.size() + 1);
        data.add(project);
    }

    @Override
    public Project find(int id) {
        return data.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public Project edit(Project editedProject) {
        Project baseProject = this.find(editedProject.getId());
        baseProject.setName(editedProject.getName());
        baseProject.setDescription(editedProject.getDescription());
        baseProject.setShortDesc(editedProject.getShortDesc());
        baseProject.setOrganisation(editedProject.getOrganisation());
        baseProject.setRequirements(editedProject.getRequirements());
        baseProject.setTags(editedProject.getTags());
        baseProject.setStatus(editedProject.getStatus());
        return baseProject;
    }

    @Override
    public Stream<Project> getAll() {
        return data.stream();
    }

    @Override
    public Stream<Project> getBy(String status) {
        return data.stream().filter(p -> p.getStatus().toString().equals(status));
    }

    @Override
    public Stream<Project> getBy(List<String> compareTags) {
        return data.stream().filter(p -> p.tagsContainCompareTag(compareTags));
    }

}
