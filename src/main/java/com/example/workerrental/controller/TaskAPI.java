package com.example.workerrental.controller;

import com.example.workerrental.model.CustomerDTO;
import com.example.workerrental.model.TaskDTO;
import com.example.workerrental.service.impl.CustomerServiceImpl;
import com.example.workerrental.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskAPI {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping("/api/task")
    public ResponseEntity<TaskDTO> getTaskById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(taskServiceImpl.getTaskById(id));
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {
        return ResponseEntity.ok(taskServiceImpl.getAllTasks());
    }

    @PostMapping("/api/task")
    public ResponseEntity<TaskDTO> createTask(@RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskServiceImpl.createTask(taskDTO));
    }

    @PutMapping("/api/task")
    public ResponseEntity<TaskDTO> updateTask(@RequestParam Long id, @RequestBody TaskDTO taskDTO) {
        return ResponseEntity.ok(taskServiceImpl.updateTask(id, taskDTO));
    }
    @DeleteMapping("/api/task")
    public ResponseEntity<Boolean> deleteTask(@RequestParam Long id) {
        return ResponseEntity.ok(taskServiceImpl.deleteTask(id));
    }
}
