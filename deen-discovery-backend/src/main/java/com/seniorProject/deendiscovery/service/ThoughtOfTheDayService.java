package com.seniorProject.deendiscovery.service;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.repository.ThoughtOfTheDayRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ThoughtOfTheDayService  { // service will communicate with the repository which takes the model and makes it communicate with the database to make a table
    private final ThoughtOfTheDayRepository thoughtOfTheDayRepository;

    // this method will just save the field values entered to the table in the database
    public ThoughtOfTheDay addThoughtOfTheDay(ThoughtOfTheDay thoughtOfTheDay) {
        return thoughtOfTheDayRepository.save(thoughtOfTheDay);
    }

    public ThoughtOfTheDay findRandomThoughtOfTheDay() { // will get the random thought of the day
        List<ThoughtOfTheDay> allThoughts = new java.util.ArrayList<>(thoughtOfTheDayRepository.findAll()); // will get all the records for us


        // Shuffle the list
        Collections.shuffle(allThoughts);

        // Return the first element (random ID)
        return allThoughts.get(0);
    }
    public ThoughtOfTheDay retrieveThoughtOfTheDay(Long id) {
        return thoughtOfTheDayRepository.findById(id).get();
    }


}
