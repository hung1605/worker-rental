package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
    CustomerEntity findByPhoneNumber(String phoneNumber);
}
