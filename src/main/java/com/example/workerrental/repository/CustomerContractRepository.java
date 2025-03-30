package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.CustomerContractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerContractRepository
        extends JpaRepository<CustomerContractEntity, Long> {
}
