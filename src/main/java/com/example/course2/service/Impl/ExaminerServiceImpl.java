package com.example.course2.service.Impl;

import com.example.course2.exception.AmountQuestionsException;
import com.example.course2.model.Question;
import com.example.course2.service.ExaminerService;
import com.example.course2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private static final Random random = new Random();
    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;

    }
    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > javaQuestionService.getAll().size()+mathQuestionService.getAll().size()) {
            throw new AmountQuestionsException();
        }
//        Set<Question> randomQuestions = new HashSet<>(amount);
//        while (randomQuestions.size() < amount) {
//            randomQuestions.add(questionService.getRandomQuestion());
//        }
//        return randomQuestions;
        return Stream.generate(()->getRandomQuestionService().getRandomQuestion())
                .distinct()
                .limit(amount)
                .collect(Collectors.toList());
    }

    private QuestionService getRandomQuestionService() {
        switch (random.nextInt(2)) {
            case 0:
                return javaQuestionService;
            case 1:
                return mathQuestionService;
            default:
                throw new RuntimeException();
        }
    }
}
