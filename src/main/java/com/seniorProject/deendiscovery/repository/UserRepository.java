package com.seniorProject.deendiscovery.repository;
import com.seniorProject.deendiscovery.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsernameOrPassword(String email, String password);

    Optional<User> findByUsername(String email);
}