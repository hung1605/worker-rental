package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findByPhoneNumber(String phoneNumber);
}
