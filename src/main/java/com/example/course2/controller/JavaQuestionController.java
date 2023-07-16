package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.Impl.JavaQuestionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final JavaQuestionService questionService;

    public JavaQuestionController(JavaQuestionService questionService) {
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
