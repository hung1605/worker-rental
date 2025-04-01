package com.example.workerrental.repository.custom;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.repository.entity.WorkerEntity;

import java.util.List;


public interface WorkerRepositoryCustom {
    List<WorkerEntity> searchWorker(WorkerSearchBuilder workerSearchBuilder);
}
