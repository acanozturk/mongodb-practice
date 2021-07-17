package com.practice.mongodb.exceptions;

import com.practice.mongodb.api.responses.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {RuntimeException.class})
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ExceptionResponse handleNullPointerException(RuntimeException exception) {
        final ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setMessage(exception.getMessage());

        return exceptionResponse;
    }

}
