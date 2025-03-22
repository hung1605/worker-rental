package com.example.workerrental.repository.impl;

import com.example.workerrental.model.Worker;
import com.example.workerrental.repository.WorkerRepository;
import org.springframework.stereotype.Repository;

@Repository
public class WorkerRepositoryImpl implements WorkerRepository {
    @Override
    public Worker getWorker() {
        Worker worker = new Worker();
        worker.setName("Hoang Phuc Dep Zai");
        worker.setPhoneNumber("099999996868");
        worker.setGender("Nam");
        return worker;
    }

}
