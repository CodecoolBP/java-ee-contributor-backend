package com.codecool.contributor.config;

import com.codecool.contributor.entity.Project;
import com.codecool.contributor.entity.User;
import com.codecool.contributor.service.ProjectStorage;
import com.codecool.contributor.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class Initializer {

    @Autowired
    private ProjectStorage projectStorage;

    @Autowired
    private UserStorage userStorage;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {

        return args -> {

            Project vöröskereszt = Project.builder()
                    .title("Learn first aid - app")
                    .shortDesc("Refresh your knowledge in first aid")
                    .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                    .organisation("Vöröskereszt")
                    .requirements("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                    .build();

            Project pharmap = Project.builder()
                    .title("Pharmacy map")
                    .shortDesc("A simple map application that shows you on a map the nearest pharmacys for you. You can add different addresses and a length in Km to the farest pharmacy. You can save locations, your and the pharmacy's locations as well")
                    .description("A simple map application with the nearest pharmacys")
                    .organisation("Pharmap")
                    .requirements("Map API (Google Maps and Apple Maps for example.) User login to save locations")
                    .build();

            Project doggo = Project.builder()
                    .title("Animal shelter web app")
                    .shortDesc("A web application for an animal shelter.")
                    .description("Web application for an animal shelter for an easier adoption process. We'd like a list of the animals with a datapage for each of them. And also we'd like a Map on our page for the soon to be adopters to find us easily")
                    .organisation("Doggo")
                    .requirements("User registration, list of animals, datapage for animals, contact menu, map")
                    .build();

            Project suitup = Project.builder()
                    .title("Clothes collecting app")
                    .shortDesc("Clothes collecting places mobile app")
                    .description("A simple mobile app (for Android and iOS too) that lists all the clothes collecting places with the type of clothes they need (adult, little girl or boy clothes etc.) The app would show the place's contacts, addresses and shows them on a map as well. It also sends you notification about the upcomming clothes collecting events.")
                    .organisation("Suit Up")
                    .requirements("List of clothes collecting places, Each of the places their own: contact page, address displayed on a map and clothes needs.")
                    .build();

            Project childrenshope = Project.builder()
                    .title("Children's home donation page")
                    .shortDesc( "A simple donating page")
                    .description("A simple donation page for a children's home. You can send donations, check previous donating people and you can also read about the organisation's history and work")
                    .organisation("Children's hope")
                    .requirements("Donateing page, bank API, Organisation bio page, Previous donators page")
                    .build();

            User user1 = User.builder()
                    .email("user1@codecool.com")
                    .password("1234Codecool")
                    .type(User.UserType.ORGANISATION)
                    .project(vöröskereszt)
                    .project(suitup)
                    .build();

            User user2 = User.builder()
                    .email("user2@codecool.com")
                    .password("1234Codecool")
                    .type(User.UserType.ORGANISATION)
                    .project(doggo)
                    .project(pharmap)
                    .project(childrenshope)
                    .build();

            vöröskereszt.setUser(user1);
            pharmap.setUser(user2);
            doggo.setUser(user2);
            suitup.setUser(user1);
            childrenshope.setUser(user2);

            userStorage.add(user1);
            userStorage.add(user2);

        };

    }
}
