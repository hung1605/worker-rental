package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {


}
