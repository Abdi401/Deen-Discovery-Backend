package com.seniorProject.deendiscovery.service;

import com.seniorProject.deendiscovery.model.User;
import com.seniorProject.deendiscovery.model.entity.UserRoles;
import com.seniorProject.deendiscovery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User retrieveUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean validateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
        return user.isPresent();
    }

    public List<User> getUsersByRole(UserRoles role) {
        return userRepository.findByRole(role);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    public User getLoggedInUser() {

        return null;
    }
}
