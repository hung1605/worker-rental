package com.example.workerrental.service;

import com.example.workerrental.model.TaskDTO;

import java.util.List;

public interface TaskService {
    TaskDTO getTaskById(Integer id);
    List<TaskDTO> getAllTasks();
    TaskDTO createTask(TaskDTO taskDTO);
    TaskDTO updateTask(Integer id, TaskDTO taskDTO);
    Boolean deleteTask(Integer id);
}
