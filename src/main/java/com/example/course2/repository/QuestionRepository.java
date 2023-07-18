package com.example.course2.repository;

import com.example.course2.model.Question;

import java.util.List;
public interface QuestionRepository {

    Question add(Question question);
    Question remove(Question question);
    List<Question> getAll();

}
