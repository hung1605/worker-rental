package com.example.workerrental.service;

import com.example.workerrental.model.CustomerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerService {
    CustomerDTO getCustomerById(Long id);
    List<CustomerDTO> getAllCustomers();
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO);
    Boolean deleteCustomer(Long id);
}
