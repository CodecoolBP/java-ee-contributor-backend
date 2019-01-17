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

        projectStorage.add(new Project("ProjectCook", "Cook some stuff!", "cooky", "cCompany", "Igen", tags, EnumStatus.valueOf("CLOSED")));
        projectStorage.add(new Project("ProjectBoi", "Boiboiboi!", "CsakBo", "Boicompany", "Igeb", tags, EnumStatus.valueOf("OPEN")));
        tags2.add("taglalat");
        projectStorage.add(new Project("ProjectTagTest", "tagtest!", "Nem", "TestCompy", "reqi", tags2, EnumStatus.valueOf("OPEN")));
        projectStorage.add(new Project("Animal shelter web app", "Web application for an animal shelter for an easier adoption process. We'd like a list of the animals with a datapage for each of them. And also we'd like a Map on our page for the soon to be adopters to find us easily", "A web application for an animal shelter.", "Doggo", "User registration, list of animals, datapage for animals, contact menu, map", tags2, EnumStatus.valueOf("OPEN")));
        projectStorage.add(new Project("Children's home donation page", "A simple donation page for a children's home. You can send donations, check previous donating people and you can also read about the organisation's history and work", "A simple donating page", "Children's hope", "Donateing page, bank API, Organisation bio page, Previous donators page", tags2, EnumStatus.valueOf("OPEN")));
        projectStorage.add(new Project("Pharmacy map", "A simple map application that shows you on a map the nearest pharmacys for you. You can add different addresses and a length in Km to the farest pharmacy. You can save locations, your and the pharmacy's locations as well", "A simple map application with the nearest pharmacys", "Pharmap", "Map API (Google Maps and Apple Maps for example.) User login to save locations", tags2, EnumStatus.valueOf("OPEN")));
        projectStorage.add(new Project("Clothes collecting app", "A simple mobile app (for Android and iOS too) that lists all the clothes collecting places with the type of clothes they need (adult, little girl or boy clothes etc.) The app would show the place's contacts, addresses and shows them on a map as well. It also sends you notification about the upcomming clothes collecting events.", "Clothes collecting places mobile app", "Suit Up", "List of clothes collecting places, Each of the places their own: contact page, address displayed on a map and clothes needs.", tags2, EnumStatus.valueOf("INPROGRESS")));

    }
}
