package com.example.course2.repository.impl;

import com.example.course2.exception.QuestionAlreadyExistsException;
import com.example.course2.exception.QuestionNotFoundException;
import com.example.course2.model.Question;
import com.example.course2.repository.QuestionRepository;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class JavaQuestionRepositoryImpl implements QuestionRepository {
    private final List<Question> questions = new ArrayList<>();
    @Override
    public Question add(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public List<Question> getAll() {
        return Collections.unmodifiableList(questions);
    }
}
