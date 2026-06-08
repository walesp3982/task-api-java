package com.walter.task_api.dto;

import jakarta.validation.constraints.NotBlank;

public record CreateTaskDTO(
        @NotBlank String title,
        String description
) { }
