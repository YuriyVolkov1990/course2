package com.example.course2.controller;

import com.example.course2.model.Question;
import com.example.course2.service.Impl.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }
    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) {
        return examinerService.getQuestions(amount);
    }
}
