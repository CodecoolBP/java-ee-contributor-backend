package com.codecool.contributor.service;

import com.codecool.contributor.model.User;

public interface UserStorage {

    void add(User user);
    User find(int id);
    void remove(int id);
    User edit(User editedProject );
}
