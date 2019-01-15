package com.codecool.contributor.service;

import com.codecool.contributor.model.Project;

import java.util.stream.Stream;

public interface ProjectStorageInt {

    void add(Project product);
    Project find(int id);
    void remove(int id);

    Stream<Project> getAll();
}
