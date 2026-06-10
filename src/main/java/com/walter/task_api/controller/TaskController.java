package com.walter.task_api.controller;

import com.walter.task_api.controller.exceptions.TaskNotFoundByIdException;
import com.walter.task_api.dto.CreateTaskDTO;
import com.walter.task_api.model.Task;
import com.walter.task_api.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final TaskRepository repository;

    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public Iterable<Task> getTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public Task saveTask(@Valid @RequestBody CreateTaskDTO dto) {
        Task task = new Task(
                dto.title(),
                dto.description()
        );
        return repository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new TaskNotFoundByIdException(id));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task newTask) {

        return repository.findById(id).map(
                task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setCompleted(newTask.isCompleted());
                    return repository.save(task);
                }
        ).orElseGet(
                () -> repository.save(newTask)
        );
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        repository.deleteById(id);
    }

}
