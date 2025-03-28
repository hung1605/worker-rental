package com.example.workerrental.service;

import com.example.workerrental.model.WorkerDTO;

public interface WorkerService {
    WorkerDTO getWorker();
    WorkerDTO addWorker(WorkerDTO workerDTO);
}
