package com.example.course2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class QuestionAndAnswerEqualsException extends RuntimeException{
    public QuestionAndAnswerEqualsException() {
    }

    public QuestionAndAnswerEqualsException(String message) {
        super(message);
    }

    public QuestionAndAnswerEqualsException(String message, Throwable cause) {
        super(message, cause);
    }

    public QuestionAndAnswerEqualsException(Throwable cause) {
        super(cause);
    }

    public QuestionAndAnswerEqualsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
