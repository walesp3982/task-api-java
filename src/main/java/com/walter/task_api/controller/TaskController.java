package com.walter.task_api.controller;

import com.walter.task_api.dto.CreateTaskDTO;
import com.walter.task_api.model.Task;
import com.walter.task_api.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TaskController {
    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public Iterable<Task> getTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task saveTask(@Valid @RequestBody CreateTaskDTO dto) {
        Task task = new Task(
                dto.title(),
                dto.description()
        );
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTask(@PathVariable Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    @PutMapping("/tasks/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task newTask) {

        return taskRepository.findById(id).map(
                task -> {
                    task.setTitle(newTask.getTitle());
                    task.setDescription(newTask.getDescription());
                    task.setCompleted(newTask.isCompleted());
                    return taskRepository.save(task);
                }
        ).orElseGet(
                () -> taskRepository.save(newTask)
        );
    }

    @DeleteMapping("/tasks/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskRepository.deleteById(id);
    }

}
