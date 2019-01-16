package com.codecool.contributor.config;

import com.codecool.contributor.model.EnumStatus;
import com.codecool.contributor.model.Project;
import com.codecool.contributor.service.implementation.ProjectStorageMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class Initializer {

    @Autowired
    private ProjectStorageMem projectStorage;

    @Bean
    public void init() {
        ArrayList<String> tags = new ArrayList<>();
        tags.add("tag1");
        tags.add("tag2");
        ArrayList<String> tags2 = new ArrayList<>();

        projectStorage.add(new Project("ProjectCook", "Cook some stuff!", "Igen", tags, EnumStatus.valueOf("CLOSED")));
        projectStorage.add(new Project("ProjectBoi", "Boiboiboi!", "Nem", tags, EnumStatus.valueOf("OPEN")));
        tags2.add("taglalat");
        projectStorage.add(new Project("ProjectTagTest", "tagtest!", "Nem", tags2, EnumStatus.valueOf("OPEN")));

    }
}
