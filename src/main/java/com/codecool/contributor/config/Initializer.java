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

import java.util.ArrayList;
import java.util.List;

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

            Project redcross = Project.builder()
                    .title("Learn first aid - app")
                    .shortDesc("Refresh your knowledge in first aid.")
                    .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                    .organisation("Vöröskereszt")
                    .requirements("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
                    .build();

            Project pharmap = Project.builder()
                    .title("Pharmacy map")
                    .shortDesc("A simple map application with the nearest pharmacys.")
                    .description("A simple map application that shows you on a map the nearest pharmacys for you. You can add different addresses and a length in Km to the farest pharmacy. You can save locations, your and the pharmacy's locations as well.")
                    .organisation("Pharmap")
                    .requirements("Map API (Google Maps and Apple Maps for example.) User login to save locations")
                    .build();

            Project doggo = Project.builder()
                    .title("Animal shelter web app")
                    .shortDesc("A web application for an animal shelter.")
                    .description("Web application for an animal shelter for an easier adoption process. We'd like a list of the animals with a datapage for each of them. And also we'd like a Map on our page for the soon to be adopters to find us easily.")
                    .organisation("Doggo")
                    .requirements("User registration, list of animals, datapage for animals, contact menu, map")
                    .build();

            Project suitup = Project.builder()
                    .title("Clothes collecting app")
                    .shortDesc("Clothes collecting places mobile app.")
                    .description("A simple mobile app (for Android and iOS too) that lists all the clothes collecting places with the type of clothes they need (adult, little girl or boy clothes etc.) The app would show the place's contacts, addresses and shows them on a map as well. It also sends you notification about the upcomming clothes collecting events.")
                    .organisation("Suit Up")
                    .requirements("List of clothes collecting places, Each of the places their own: contact page, address displayed on a map and clothes needs.")
                    .build();

            Project childrenshope = Project.builder()
                    .title("Children's home page")
                    .shortDesc( "A simple donating page.")
                    .description("A simple donation page for a children's home. You can send donations, check previous donating people and you can also read about the organisation's history and work.")
                    .organisation("Children's hope")
                    .requirements("Donateing page, bank API, Organisation bio page, Previous donators page")
                    .build();

            Project tindrr = Project.builder()
                    .title("Tindrr")
                    .shortDesc( "A dating application to finally find your other half. Or just to find someone to sleep with. ( ͡° ͜ʖ ͡°)")
                    .description("You can set your preferences. Any kind of preferences. You can check other users and their profiles. If you like what you see you can swipe the user right. It's like Tinder. But it's better. Because reasons.")
                    .organisation("Tindrr")
                    .requirements("User page, swipe function, in app purchase")
                    .build();

            Project snake = Project.builder()
                    .title("Snake")
                    .shortDesc( "A remastered version of the good old Snake game from Nokia phones.")
                    .description("You play as a snake. A short snake first. Every time you eat a fruit, you'll gain size. The goal is to survive as long as you can, but be aware, that if you bite your own tail, or hit the wall, the games is over!")
                    .organisation("Nokia")
                    .requirements("A simple snake game, score counter, power ups, walls, maybe maze like levels")
                    .build();

            Project bubble = Project.builder()
                    .title("Bubble popping")
                    .shortDesc( "A simple bubble wrap popping game.")
                    .description("Do you remember when you were so bored you started to popping bubble wrap? Well you can do it now on your iOS or Android phone. No more boring traveling, or waiting for your pizza to arrive. Bubble popping is at your service. What a time to be alive!")
                    .organisation("Funky apps")
                    .requirements("bubble page, when tapped the bubble pops, time counter, high score, iOS and Android version")
                    .build();

            Project tobacco = Project.builder()
                    .title("National Tobacco Store finder")
                    .shortDesc( "A simple app to find the nearest tobacco store.")
                    .description("Do you ever came out from Instant to smoke a cigarette but you had none? Now you don't have to search for a tobacco store stressful. Simply just open our app and it will display for you the nearest ones. You can set direction to it as well.")
                    .organisation("Trafikosok szövetsége")
                    .requirements("Apple and Google maps integration, list page of tobacco stores")
                    .build();

            Project vote = Project.builder()
                    .title("Voter")
                    .shortDesc( "A simple app that geathers the actual candidates to make a rational choice.")
                    .description("You want to vote but you don't know who you should? Our application will help you geather the necessary informations about actual parties and the Prime Minister candidates. You can set each party to your favourite and also you can compare them to find which suits you best.")
                    .organisation("Go Vote!")
                    .requirements("Party and candidates list, favourite list")
                    .build();

            Project movie = Project.builder()
                    .title("Movie downloader")
                    .shortDesc("You know a movie that you want to see badly but you don't want to spend money on it? Let us help you!")
                    .description("With our website you can view movies online or even download them not so legally but at least free.")
                    .organisation("Anonymus")
                    .requirements("Movie list, download option")
                    .build();

            User user1 = User.builder()
                    .email("kinga00099@gmail.com")
                    .project(redcross)
                    .project(suitup)
                    .project(tindrr)
                    .project(tobacco)
                    .build();

            User user2 = User.builder()
                    .email("mano.czar@gmail.com")
                    .project(doggo)
                    .project(pharmap)
                    .project(childrenshope)
                    .project(snake)
                    .project(vote)
                    .build();

            User user3 = User.builder()
                    .email("user3@codecool.com")
                    .project(bubble)
                    .project(movie)
                    .build();

            redcross.setProjectOwner(user1);
            pharmap.setProjectOwner(user2);
            doggo.setProjectOwner(user2);
            suitup.setProjectOwner(user1);
            childrenshope.setProjectOwner(user2);
            tindrr.setProjectOwner(user1);
            snake.setProjectOwner(user2);
            bubble.setProjectOwner(user3);
            tobacco.setProjectOwner(user1);
            vote.setProjectOwner(user2);
            movie.setProjectOwner(user3);
            List<User> tempList = new ArrayList<>();
            tempList.add(user3);
            redcross.setContributors(tempList);
            userStorage.add(user3);
            userStorage.add(user1);
            userStorage.add(user2);
            List<Project> tempList2 = new ArrayList<>();
            tempList2.add(redcross);
            user3.setContributions(tempList2);
            userStorage.edit(user3);

        };

    }
}
