package com.example.workerrental.service;

import com.example.workerrental.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO getTaskById(Long id);
    List<TaskDTO> getAllTasks();
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    Boolean deleteTask(Long id);
}
