package com.example.workerrental.repository.custom;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.repository.entity.Worker;

import java.util.List;


public interface WorkerRepositoryCustom {
    List<Worker> searchWorker(WorkerSearchBuilder workerSearchBuilder);
}
