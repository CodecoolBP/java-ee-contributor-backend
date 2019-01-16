package com.codecool.contributor.service;

import com.codecool.contributor.model.Project;

import java.util.stream.Stream;

public interface ProjectStorageInt {

    void add(Project product);
    Project find(int id);
    void remove(int id);

    Stream<Project> getAll();

    Stream<Project> getBy(String status);
    Stream<Project> getBy(String[] tags);

    default Stream<Project> getBy(String status, String[] tags) {
        if (status == null && tags == null) {
            return getAll();
        } else if (tags == null) {
            return getBy(status);
        } else if (status == null) {
            return getBy(tags);
        } else {
            return getBy(status).filter(p -> p.getTags().equals());
        }
    }
}
