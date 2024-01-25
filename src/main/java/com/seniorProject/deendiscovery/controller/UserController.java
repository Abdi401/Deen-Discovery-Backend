package com.seniorProject.deendiscovery.controller;

import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.model.User;
import com.seniorProject.deendiscovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}") // this url will expect a  field called id , which retrieves the user
    public User getUser(@PathVariable Long id ) { // this method returns the user having id there helps with telling the database what to specifically get based on the id
        return userService.retrieveUser(id);
    }

    // Additional endpoints can go here, such as retrieving a user by ID, updating a user, etc.
}
