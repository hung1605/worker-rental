package com.example.workerrental.controller;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkerAPI {
    @Autowired
    private WorkerService workerService;
    @GetMapping("/api/worker/")
    public WorkerDTO getWorker(){
        return workerService.getWorker();
    }

    @PostMapping("/api/addWorker")
    public WorkerDTO addWorker(@RequestBody WorkerDTO newWorker, ){

    }
}
