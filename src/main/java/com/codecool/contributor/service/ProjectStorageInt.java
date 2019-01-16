package com.codecool.contributor.service;

import com.codecool.contributor.model.Project;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ProjectStorageInt {

    void add(Project product);
    Project find(int id);
    void remove(int id);

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
