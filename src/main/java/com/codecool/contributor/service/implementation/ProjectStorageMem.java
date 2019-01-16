package com.codecool.contributor.service.implementation;


import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.ProjectStorageInt;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ProjectStorageMem implements ProjectStorageInt {

    private List<Project> data = new ArrayList<>();

    @Override
    public void add(Project project) {
        project.setId(data.size() + 1);
        data.add(project);
    }

    @Override
    public Project find(int id) {
        return data.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void remove(int id) {
        data.remove(find(id));
    }

    @Override
    public Stream<Project> getAll() {
        return data.stream();
    }

    @Override
    public Stream<Project> getBy(String status) {

    }
}
