package com.seniorProject.deendiscovery.repository;

import com.seniorProject.deendiscovery.model.User;
import com.seniorProject.deendiscovery.model.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);

    List<User> findByRole(UserRoles role);
}

