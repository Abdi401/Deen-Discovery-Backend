package com.seniorProject.deendiscovery.controller;

import com.seniorProject.deendiscovery.model.Course;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // provides the endpoint, requires
@RequiredArgsConstructor
@RequestMapping("/courses")

public class CourseController {
    private final CourseService courseService;
    @PostMapping("/create") // create an endpoint
    public Course createCourse(@RequestBody Course course) { // creating the method to add something to the table, requestbody says come with the request
        // we want to return a created thought of the day
        return courseService.addCourse(course);
    }

    @GetMapping("/{id}") // this url will expect a  field called id , which retrieves course by id
    public Course getCourse( @PathVariable Long id ) { // this method returns the thought having id there helps with telling the database what to specifically get based on the id
        return courseService.retrieveCourse(id);
    }

    @GetMapping("/course/{courseCode}")
    public Course getByCourseCode(@PathVariable String courseCode) {
        return courseService.retrieveCourseByCourseCode(courseCode);
    }





}


