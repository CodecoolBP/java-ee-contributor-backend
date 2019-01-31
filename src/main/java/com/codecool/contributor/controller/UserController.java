package com.codecool.contributor.controller;

import com.codecool.contributor.entity.Project;
import com.codecool.contributor.entity.User;
import com.codecool.contributor.service.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value={"/api", "/"})
public class UserController {

    @Autowired
    private UserStorage userStorage;

    @GetMapping(value="/user/{id}")
    public User userById(@PathVariable("id") Integer id) {
        return userStorage.find(id);
    }

    @PostMapping("/user/add")
    public User addUser(@RequestBody User user) {
        this.userStorage.add(user);
        return user;
    }

    @DeleteMapping(value="/user/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        this.userStorage.remove(id);
        return "Success.";
    }

    @PutMapping(value="/user/{id}")
    public User editUserById(@PathVariable("id") Integer id, @RequestBody User editedUser) {
        if (id.equals(editedUser.getId())) {
            return this.userStorage.edit(editedUser);
        }
        return null;
    }
}