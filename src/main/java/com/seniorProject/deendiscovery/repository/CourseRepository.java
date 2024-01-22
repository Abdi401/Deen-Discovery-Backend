package com.seniorProject.deendiscovery.repository;

import com.seniorProject.deendiscovery.model.Course;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository // says this is the repo class
public interface CourseRepository extends JpaRepository<Course, Long> {

    Optional<Course> findById(Long id); // creates a method defintiiton
    Optional<Course> findByCourseCode(String courseCode);
}
