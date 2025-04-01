package com.example.workerrental.service;

import com.example.workerrental.model.WorkerDTO;

import java.util.List;
import java.util.Map;

public interface WorkerService {
    List<WorkerDTO> searchWorker(Map<String, String> field, List<String> skillId);
    WorkerDTO getWorker(Long id);
    List<WorkerDTO> getWorkers();
    WorkerDTO addWorker(WorkerDTO workerDTO);
    WorkerDTO updateWorker(Long id, WorkerDTO workerDTO);
    void deleteWorker(Long id);
}
