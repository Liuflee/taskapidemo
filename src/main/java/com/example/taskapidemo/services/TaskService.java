package com.example.taskapidemo.services;

import com.example.taskapidemo.dto.TaskRequest;
import com.example.taskapidemo.dto.TaskResponse;
import com.example.taskapidemo.models.Task;
import com.example.taskapidemo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

public TaskResponse createTask(TaskRequest request) {

    Task task = new Task(
        request.getTitle(),
        request.isCompleted()
    );

    Task savedTask = taskRepository.save(task);

    return new TaskResponse(
        savedTask.getId(),
        savedTask.getTitle(),
        savedTask.isCompleted()
    );
}


    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada: " + id));
    }

    public Task deleteTask(Long id) {
        Task task = getTaskById(id);
        taskRepository.delete(task);
        return task;
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(updatedTask.getTitle());
        existingTask.setCompleted(updatedTask.isCompleted());
        return taskRepository.save(existingTask);
    }

    public TaskResponse updateTask(Long id, TaskRequest request) {
        Task existingTask = getTaskById(id);
        existingTask.setTitle(request.getTitle());
        existingTask.setCompleted(request.isCompleted());
        Task updatedTask = taskRepository.save(existingTask);

        return new TaskResponse(
                updatedTask.getId(),
                updatedTask.getTitle(),
                updatedTask.isCompleted()
        );
    }
}
