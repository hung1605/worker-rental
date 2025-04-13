package com.example.workerrental.service;

import com.example.workerrental.repository.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Long id, Customer customer);
    Boolean deleteCustomer(Long id);
}
