package com.example.workerrental.service.impl;



import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.TaskRepository;

import com.example.workerrental.repository.entity.Task;
import com.example.workerrental.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    @Transactional
    public Task getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) throw new RuntimeException("Task not found with id: " + id);
        return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) throw new RuntimeException("Task not found with id: " + id);
        Task oldTask = optionalTask.get();
        newTask.setId(oldTask.getId());
        return taskRepository.save(newTask);
    }

    @Override
    public Boolean deleteTask(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) return false;
        taskRepository.deleteById(id);
        return true;
    }
}
