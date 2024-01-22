package com.seniorProject.deendiscovery.controller;

import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.service.ThoughtOfTheDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/thoughts") // if you use postman, you need to put /thoughts after localhost
@CrossOrigin
public class ThoughtOfTheDayController { // the thoughtofdayservice will connect with the controller to be able to create the endpoints for the app
    private  final ThoughtOfTheDayService thoughtOfTheDayService;

    @PostMapping ("/create") // create an endpoint
    public ThoughtOfTheDay createThoughtOfTheDay( @RequestBody ThoughtOfTheDay thoughtOfTheDay) { // creating the method to add something to the table, requestbody says come with the request
        // we want to return a created thought of the day
        return thoughtOfTheDayService.addThoughtOfTheDay(thoughtOfTheDay);
    }

    @GetMapping("/{id}") // this url will expect a  field called id , which retrieves the thought
    public ThoughtOfTheDay getThoughtOfTheDay( @PathVariable Long id ) { // this method returns the thought having id there helps with telling the database what to specifically get based on the id
        return thoughtOfTheDayService.retrieveThoughtOfTheDay(id);
    }

    @GetMapping("/thoughtOfTheDay")
    public ThoughtOfTheDay getRandomThought() {
        return thoughtOfTheDayService.findRandomThoughtOfTheDay();
    }

}


