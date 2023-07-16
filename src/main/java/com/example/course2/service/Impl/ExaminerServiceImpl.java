package com.example.course2.service.Impl;

import com.example.course2.exception.AmountQuestionsException;
import com.example.course2.model.Question;
import com.example.course2.service.ExaminerService;
import com.example.course2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size()) {
            throw new AmountQuestionsException();
        }
//        Set<Question> randomQuestions = new HashSet<>(amount);
//        while (randomQuestions.size() < amount) {
//            randomQuestions.add(questionService.getRandomQuestion());
//        }
//        return randomQuestions;
        return Stream.generate(() -> questionService.getRandomQuestion())
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }

}
