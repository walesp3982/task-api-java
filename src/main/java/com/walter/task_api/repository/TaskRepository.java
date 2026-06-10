package com.walter.task_api.repository;

import com.walter.task_api.dto.CreateTaskDTO;
import com.walter.task_api.model.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
