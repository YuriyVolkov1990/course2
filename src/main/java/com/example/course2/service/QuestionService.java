package com.example.course2.service;

import com.example.course2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question addQuestion(String question, String answer);
    Question addQuestion(Question question);
    Question removeQuestion(String question, String answer);
    Question removeQuestion(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();

}
