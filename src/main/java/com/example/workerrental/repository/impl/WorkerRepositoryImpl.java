package com.example.workerrental.repository.impl;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.repository.entity.WorkerEntity;
import org.springframework.stereotype.Repository;

@Repository


public class WorkerRepositoryImpl implements WorkerRepository {

    @Override
    public WorkerDTO getWorker() {
        WorkerDTO worker = new WorkerDTO();
        worker.setName("Hoang Phuc Dep Zai");
        worker.setPhoneNumber("099999996868");
        worker.setGender("Nam");
        return worker;
    }

}
