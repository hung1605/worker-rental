package com.example.workerrental.service.impl;

import com.example.workerrental.model.Worker;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Override
    public Worker getWorker() {
        return workerRepository.getWorker();
    }
}
