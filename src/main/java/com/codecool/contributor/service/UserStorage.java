package com.codecool.contributor.service;

import com.codecool.contributor.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserStorage {

    void add(User user);
    User find(int id);
    User findByEmail(String email);
    void remove(int id);
    User edit(User editedUser );
}
