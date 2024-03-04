package com.seniorProject.deendiscovery.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Configuration
public class QuizService {
    private final RestTemplate restTemplate;
    private final String apiUrl = "https://quizapi.io/api/v1/questions";
    private final String apiKey;

    public QuizService(RestTemplate restTemplate, @Value("${quizapi.token}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }

    public String fetchQuizzes() {
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(apiUrl)
                .queryParam("apiKey", apiKey); // Use the injected apiKey here

        return restTemplate.getForObject(uriBuilder.toUriString(), String.class);
    }
}
