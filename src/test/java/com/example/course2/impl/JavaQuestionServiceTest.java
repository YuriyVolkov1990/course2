package com.example.course2.impl;

import com.example.course2.model.Question;
import com.example.course2.repository.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    QuestionRepository questionRepository;
    List<Question> questions = List.of(
            new Question("q", "w"),
            new Question("e", "r"),
            new Question("t", "y"),
            new Question("u", "i"),
            new Question("o", "p")
    );
    @Test
    void addQuestionTest() {
        when(questionRepository.add(questions.get(0)))
                .thenReturn(questions.get(0));
        assertEquals(questions.get(0), questionRepository.add(questions.get(0)));
        verify(questionRepository, only()).add(questions.get(0));
    }
    @Test
    void removeQuestionTest() {
        when(questionRepository.remove(questions.get(0)))
                .thenReturn(questions.get(0));
        assertEquals(questions.get(0), questionRepository.remove(questions.get(0)));
        verify(questionRepository, only()).remove(questions.get(0));
    }
    @Test
    void getAllTest() {
        when(questionRepository.getAll())
                .thenReturn(questions);
        assertEquals(questions, questionRepository.getAll());
        verify(questionRepository).getAll();
    }
}
