package com.walter.task_api.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String title;

    private String description;

    private boolean completed = false;

    public Task() {

    }
    public Task(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("Customer[id=%d,title=%s,description=%s, done=%b]",
                this.id, this.title, this.description, this.completed);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}