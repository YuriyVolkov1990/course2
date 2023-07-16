package com.example.course2.service.Impl;

import com.example.course2.exception.AmountQuestionsException;
import com.example.course2.model.Question;
import com.example.course2.service.ExaminerService;
import com.example.course2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new AmountQuestionsException();
        }
        Set<Question> randomQuestions = new HashSet<>(amount);
        for (int i = 0; i < amount-1; i++) {
            randomQuestions.add(questionService.getRandomQuestion());
        }
        return randomQuestions;
    }

}
