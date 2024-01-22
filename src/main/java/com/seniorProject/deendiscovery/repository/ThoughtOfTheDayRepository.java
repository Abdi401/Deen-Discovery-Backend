package com.seniorProject.deendiscovery.repository;

import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ThoughtOfTheDayRepository extends JpaRepository<ThoughtOfTheDay, Long> {  // connects the model to the database using the model and the primary key
      Optional<ThoughtOfTheDay> findById(Long id); // creates a method defintiiton


}
