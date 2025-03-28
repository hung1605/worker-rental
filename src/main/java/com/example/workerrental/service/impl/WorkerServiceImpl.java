package com.example.workerrental.service.impl;

import com.example.workerrental.converter.WorkerConverter;
import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private WorkerConverter workerConverter;
    @Override
    public WorkerDTO getWorker() {
        return workerRepository.getWorker();
    }

    @Override
    public WorkerDTO addWorker(WorkerDTO workerDTO) {

        WorkerEntity workerEntity = workerConverter.copverterToEntity(workerDTO);





        workerDTO.setStatus(1);
        return ;
    }
}
