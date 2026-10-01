package com.example.taskapidemo.repositories;

import com.example.taskapidemo.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
