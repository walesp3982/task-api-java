package com.walter.task_api.controller;

import com.walter.task_api.controller.exceptions.TaskNotFoundByIdException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskNotFoundAdvice {

    @ExceptionHandler(TaskNotFoundByIdException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String taskNotFoundByIdException(TaskNotFoundByIdException ex) {
        return ex.getMessage();
    }
}
