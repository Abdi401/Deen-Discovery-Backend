package com.seniorProject.deendiscovery.service;

import com.seniorProject.deendiscovery.model.Course;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public Course addCourse(Course course) {
            return courseRepository.save(course);
        }

    public Course retrieveCourse(Long id) {
        return  courseRepository.findById(id).get();
    }

    public Course retrieveCourseByCourseCode(String courseCode) {
        return courseRepository.findByCourseCode(courseCode).get();
    }
}

