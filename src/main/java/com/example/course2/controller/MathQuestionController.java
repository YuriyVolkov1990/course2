package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/math")
public class MathQuestionController {
    private final QuestionService questionService;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService questionService) {
        this.questionService = questionService;
    }
    @GetMapping("/add")
    public Question addQuestion(String question, String answer) {
        return questionService.addQuestion(question, answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion(String question, String answer) {
        return questionService.removeQuestion(question, answer);
    }
    @GetMapping
    public Collection<Question> getAll() {
        return questionService.getAll();
    }
}
