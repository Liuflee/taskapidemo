package com.example.taskapidemo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {
    @NotBlank(message = "Titulo obligatorio")
    @Size (max = 100, message = "El titulo no puede tener mas de 100 caracteres")
    private String title;
    private boolean completed;

    public TaskRequest() {
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
