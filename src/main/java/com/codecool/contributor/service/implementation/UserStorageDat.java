package com.codecool.contributor.service.implementation;


import com.codecool.contributor.entity.User;
import com.codecool.contributor.repository.UserRepository;
import com.codecool.contributor.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStorageDat implements UserStorage {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public User find(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public User edit(User editedUser) {
        User baseUser = userRepository.findById(editedUser.getId()).orElse(null);
        if (baseUser != null) {
            userRepository.saveAndFlush(editedUser);
            return baseUser;
        }
        return null;
    }
}
