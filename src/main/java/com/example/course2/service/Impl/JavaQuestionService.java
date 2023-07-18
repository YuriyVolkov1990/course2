package com.example.course2.service.Impl;

import com.example.course2.exception.QuestionAlreadyExistsException;
import com.example.course2.exception.QuestionAndAnswerEqualsException;
import com.example.course2.exception.QuestionNotFoundException;
import com.example.course2.model.Question;
import com.example.course2.repository.QuestionRepository;
import com.example.course2.service.QuestionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private static final Random random = new Random();
    private final QuestionRepository questionRepository;

    public JavaQuestionService(@Qualifier("javaQuestionRepositoryImpl") QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question addQuestion(String question, String answer) {
        if (Objects.equals(question, answer)) {
            throw new QuestionAndAnswerEqualsException();
        }
        return addQuestion(new Question(question, answer));
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepository.add(question);
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        return removeQuestion(new Question(question, answer));
    }

    @Override
    public Question removeQuestion(Question question) {
        return questionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return questionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        List<Question> questions = questionRepository.getAll();
        return questions.get(random.nextInt(questions.size()));
    }
}
