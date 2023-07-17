package com.example.course2.impl;

import com.example.course2.model.Question;
import com.example.course2.service.ExaminerService;
import com.example.course2.service.QuestionService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService javaQuestionService;
    @Mock
    QuestionService mathQuestionService;
    @InjectMocks
    ExaminerService examinerService;
    List<Question> questionsJava = List.of(
            new Question("q", "w"),
            new Question("e", "r"),
            new Question("t", "y"),
            new Question("u", "i"),
            new Question("o", "p")
    );
    List<Question> questionsMath = List.of(
            new Question("1", "2"),
            new Question("3", "4"),
            new Question("5", "6"),
            new Question("7", "8"),
            new Question("9", "0")
    );
    @Test
    void getQuestionsExceptionTest() {
        int sum = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        when();
    }

}
