package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.CustomerContractTaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContractTaskRepository
        extends JpaRepository<CustomerContractTaskEntity, Long> {
}
