package com.codecool.contributor.service;

import com.codecool.contributor.entity.Project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ProjectStorage {

    void add(Project project);
    Project find(int id);
    void remove(int id);
    Project edit(Project editedProject );


    Stream<Project> getAll();
    Stream<Project> getBy(String status);
    Stream<Project> getBy(List<String> tags);

    default Stream<Project> getBy(String status, List<String> tags) {
        if (status == null && tags == null) {
            return getAll();
        } else if (tags == null) {
            return getBy(status);
        } else if (status == null) {
            return getBy(tags);
        } else {
            return getBy(status).filter(p -> getBy(tags).collect(Collectors.toList()).contains(p));
        }
    }
}
