package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.Impl.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/random")
    public Collection<Question> getQuestions(int amount) {
        return examinerService.getQuestions(amount);
    }
}
