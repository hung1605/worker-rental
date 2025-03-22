package com.example.workerrental.controller;

import com.example.workerrental.model.Worker;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerAPI {
    @Autowired
    private WorkerService workerService;
    @GetMapping("/api/worker/")
    public Worker getWorker(){
        return workerService.getWorker();
    }
}
