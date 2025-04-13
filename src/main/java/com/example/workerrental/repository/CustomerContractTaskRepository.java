package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.CustomerContractTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContractTaskRepository
        extends JpaRepository<CustomerContractTask, Long> {
}
