package com.example.course2.service.Impl;

import com.example.course2.exception.QuestionAlreadyExistsException;
import com.example.course2.exception.QuestionNotFoundException;
import com.example.course2.model.Question;
import com.example.course2.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    private static final Random random = new Random();
    Set<Question> questions = new HashSet<>();
    @Override
    public Question addQuestion(String question, String answer) {
        return addQuestion(new Question(question, answer));
    }

    @Override
    public Question addQuestion(Question question) {
        if (questions.contains(question)) {
            throw new QuestionAlreadyExistsException();
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(String question, String answer) {
        return removeQuestion(new Question(question, answer));
    }

    @Override
    public Question removeQuestion(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        throw new QuestionNotFoundException();
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableCollection(questions);
    }

    @Override
    public Question getRandomQuestion() {
        Question[] forRandom = getAll().toArray(new Question[0]);
        int i = random.nextInt(questions.size());
        return forRandom[i];
    }
}
