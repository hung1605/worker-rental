package com.example.workerrental.service;

import com.example.workerrental.repository.entity.Task;

import java.util.List;

public interface TaskService {
    Task getTaskById(Long id);
    List<Task> getAllTasks();
    Task createTask(Task task);
    Task updateTask(Long id, Task task);
    Boolean deleteTask(Long id);
}
