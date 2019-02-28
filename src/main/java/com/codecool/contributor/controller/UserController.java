package com.codecool.contributor.controller;

import com.codecool.contributor.model.User;
import com.codecool.contributor.service.UserStorage;
import com.codecool.contributor.utility.JwtDecoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.jwt.Jwt;
import org.springframework.security.jwt.JwtHelper;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@RestController
@CrossOrigin
@RequestMapping(value={"/api", "/"})
public class UserController {

    @Autowired
    private UserStorage userStorage;

    @Autowired
    private HttpServletRequest request;

    @GetMapping(value="/user/{id}")
    public User userById(@PathVariable("id") Integer id) {
        return userStorage.find(id);
    }

    @GetMapping(value="/user/token")
    public User userByToken() throws IOException {
        String idToken = request.getHeader("idToken");
        HashMap claimsMap = JwtDecoder.jwtDecode(idToken);
        String userEmail = claimsMap.get("email").toString();
        return userStorage.findByEmail(userEmail);
    }

    @PostMapping("/user/add")
    public String addUser(@RequestBody String idToken) throws IOException {
        HashMap claimsMap = JwtDecoder.jwtDecode(idToken);
        Object userEmail = claimsMap.get("email");
        User newUser = User.builder()
                .email(userEmail.toString())
                .build();
        try {
            userStorage.add(newUser);
        }
        catch (DataIntegrityViolationException e) {
            System.out.println("User already in database.");
        }
        return "Success.";
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
