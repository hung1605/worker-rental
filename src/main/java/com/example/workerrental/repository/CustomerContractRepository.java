package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.CustomerContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerContractRepository
        extends JpaRepository<CustomerContract, Long> {
    List<CustomerContract> findByCustomer_Id(Long customerId);
}
