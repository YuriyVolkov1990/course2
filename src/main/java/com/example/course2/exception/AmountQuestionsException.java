package com.example.course2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AmountQuestionsException extends  RuntimeException{
    public AmountQuestionsException() {
    }

    public AmountQuestionsException(String message) {
        super(message);
    }

    public AmountQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmountQuestionsException(Throwable cause) {
        super(cause);
    }

    public AmountQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
