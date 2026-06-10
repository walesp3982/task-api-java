package com.walter.task_api.controller.exceptions;

public class TaskNotFoundByIdException extends RuntimeException{
    public TaskNotFoundByIdException(Long id) {
        super("User with id " + id + " not found");
    }
}
