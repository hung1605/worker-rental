package com.example.workerrental.repository;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.repository.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long>{


}
