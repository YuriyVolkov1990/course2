package com.example.course2.impl;

import com.example.course2.exception.AmountQuestionsException;
import com.example.course2.model.Question;
import com.example.course2.service.Impl.ExaminerServiceImpl;
import com.example.course2.service.QuestionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collection;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    QuestionService javaQuestionService;
    @Mock
    QuestionService mathQuestionService;
    @InjectMocks
    ExaminerServiceImpl examinerService;
    Collection<Question> questionsJava = List.of(
            new Question("q", "w"),
            new Question("e", "r"),
            new Question("t", "y"),
            new Question("u", "i"),
            new Question("o", "p")
    );
    Collection<Question> questionsMath = List.of(
            new Question("1", "2"),
            new Question("3", "4"),
            new Question("5", "6"),
            new Question("7", "8"),
            new Question("9", "0")
    );
    @BeforeEach
    void setup() {
        when(mathQuestionService.getAll()).thenReturn(questionsMath);
        when(javaQuestionService.getAll()).thenReturn(questionsJava);

    }
//    @Test
//    void getQuestionsExceptionTest() {
//        assertThrows(AmountQuestionsException.class,
//                () -> examinerService.getQuestions(20));
//    }
    @Test
    void getQuestionsTest() {

    }
}
