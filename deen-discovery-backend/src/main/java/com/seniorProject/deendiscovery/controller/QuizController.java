package com.seniorProject.deendiscovery.controller;

import com.seniorProject.deendiscovery.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service
@RequestMapping("/quizzes")
public class QuizController {
    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }
    @GetMapping
    public ResponseEntity<String> getQuizzes() {
        String quizzes = quizService.fetchQuizzes();
        return ResponseEntity.ok(quizzes);
    }
}
