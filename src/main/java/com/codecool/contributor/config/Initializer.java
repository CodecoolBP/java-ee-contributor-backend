package com.codecool.contributor.config;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer {

    @Autowired
    private ProjectStorageMem projectStorage;

    @Bean
    public void init() {
        projectStorage.add(new Project("ProjectCook", "Cook some stuff!"));
        projectStorage.add(new Project("ProjectBoi", "Boiboiboi!"));

    }
}
