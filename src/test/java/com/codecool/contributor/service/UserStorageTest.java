package com.codecool.contributor.service;

import com.codecool.contributor.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class UserStorageTest {

    @Autowired
    private UserStorage userStorage;

    private User testUser;

    @Before
    public void setUp() {
        testUser = User.builder()
                .email("testUser@codecool.com")
                .build();
    }

    @After
    public void tearDown() {
        userStorage.remove(testUser.getId());
    }

    @Test
    void addNewUser() {
        //TODO
    }

    @Test
    void findUserById() {
        //TODO
    }

    @Test
    void removeUserById() {
        //TODO
    }

    @Test
    void editOverwritesUser() {
        //TODO
    }
}