package com.example.workerrental.controller;

import com.example.workerrental.repository.entity.Task;
import com.example.workerrental.service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class TaskController {
    @Autowired
    private TaskServiceImpl taskServiceImpl;

    @GetMapping("/api/task")
    public ResponseEntity<Task> getTaskById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(taskServiceImpl.getTaskById(id));
    }

    @GetMapping("/api/tasks")
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskServiceImpl.getAllTasks());
    }

    @PostMapping("/api/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskServiceImpl.createTask(task));
    }

    @PutMapping("/api/task")
    public ResponseEntity<Task> updateTask(@RequestParam Long id, @RequestBody Task task) {
        return ResponseEntity.ok(taskServiceImpl.updateTask(id, task));
    }
    @DeleteMapping("/api/task")
    public ResponseEntity<Boolean> deleteTask(@RequestParam Long id) {
        return ResponseEntity.ok(taskServiceImpl.deleteTask(id));
    }
}
