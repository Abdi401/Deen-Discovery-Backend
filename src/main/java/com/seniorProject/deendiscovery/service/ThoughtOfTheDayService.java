package com.seniorProject.deendiscovery.service;
import com.seniorProject.deendiscovery.model.ThoughtOfTheDay;
import com.seniorProject.deendiscovery.repository.ThoughtOfTheDayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThoughtOfTheDayService  { // service will communicate with the repository which takes the model and makes it communicate with the database to make a table
    private final ThoughtOfTheDayRepository thoughtOfTheDayRepository;

    // this method will just save the field values entered to the table in the database
    public ThoughtOfTheDay addThoughtOfTheDay(ThoughtOfTheDay thoughtOfTheDay) {
        return thoughtOfTheDayRepository.save(thoughtOfTheDay);
    }

    public ThoughtOfTheDay retrieveThoughtOfTheDay(Long id) {
        return thoughtOfTheDayRepository.findById(id).get();
    }
}
