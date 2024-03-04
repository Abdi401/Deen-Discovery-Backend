package com.seniorProject.deendiscovery.controller;

import com.seniorProject.deendiscovery.model.User;
import com.seniorProject.deendiscovery.model.entity.UserRoles;
import com.seniorProject.deendiscovery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>("Registration successful!", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User user) {
        try {
            if (userService.validateUser(user.getUsername(), user.getPassword())) {
                User loggedInUser = userService.getUserByUsername(user.getUsername());
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Login successful!");
                response.put("user", loggedInUser);

                // Redirect based on user role
                if (loggedInUser.getRole() == UserRoles.STUDENT) {
                    response.put("redirect", "/student");
                } else if (loggedInUser.getRole() == UserRoles.INSTRUCTOR) {
                    response.put("redirect", "/instructor");
                }

                return new ResponseEntity<>(response, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/data")
    public ResponseEntity<User> getUserData() {
        // Assuming you have the user's information available in the security context
        // You may adjust this based on your authentication mechanism
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null) {
            return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.retrieveUser(id);
    }

    @GetMapping("/role/{role}")
    public List<User> getUsersByRole(@PathVariable UserRoles role) {
        return userService.getUsersByRole(role);
    }

    // Logout function
    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser() {
        // Implement logout logic here (e.g., clearing authentication session)
        // For simplicity, let's assume a successful logout
        return new ResponseEntity<>("Logout successful!", HttpStatus.OK);
    }
}
