package com.codecool.contributor.config;

import com.codecool.contributor.model.Project;
import com.codecool.contributor.model.User;
import com.codecool.contributor.service.ProjectStorage;
import com.codecool.contributor.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class InitializerTest {

    @Autowired
    private ProjectStorage projectStorage;

    @Autowired
    private UserStorage userStorage;

    @Bean
    @Profile("test")
    public CommandLineRunner initTest() {

        return args -> {

            Project redcross = Project.builder()
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

            User user1 = User.builder()
                    .email("user1@codecool.com")
                    .password("1234Codecool")
                    .type(User.UserType.ORGANISATION)
                    .project(redcross)
                    .build();

            User user2 = User.builder()
                    .email("user2@codecool.com")
                    .password("1234Codecool")
                    .type(User.UserType.ORGANISATION)
                    .project(pharmap)
                    .build();

            redcross.setUser(user1);
            pharmap.setUser(user2);

            userStorage.add(user1);
            userStorage.add(user2);

        };

    }
}
