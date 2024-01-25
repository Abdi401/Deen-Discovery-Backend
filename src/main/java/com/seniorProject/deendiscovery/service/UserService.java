
package com.seniorProject.deendiscovery.service;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.model.User;
import com.seniorProject.deendiscovery.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User retrieveUser(Long id) {
        return userRepository.findById(id).get();
    }
    public User retrieveThoughtOfTheDay(Long id) {
        return userRepository.findById(id).get();
    }

}


