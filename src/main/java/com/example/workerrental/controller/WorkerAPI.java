package com.example.workerrental.controller;

import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerAPI {
    @Autowired
    private WorkerService workerService;


    @PostMapping("/api/worker")
    public ResponseEntity<WorkerDTO> addWorker(@RequestBody WorkerDTO newWorker){
       return ResponseEntity.ok(workerService.add(newWorker));
    }
}
