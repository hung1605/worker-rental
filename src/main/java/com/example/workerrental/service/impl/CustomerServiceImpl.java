package com.example.workerrental.service.impl;

import com.example.workerrental.repository.CustomerRepository;
import com.example.workerrental.repository.entity.Customer;
import com.example.workerrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) throw new RuntimeException("Customer not found with id: " + id);
        return optionalCustomer.get();
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Long id, Customer newCustomer) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) throw new RuntimeException("Customer not found with id: " + id);
        Customer oldCustomer = optionalCustomer.get();
        newCustomer.setId(oldCustomer.getId());
        return customerRepository.save(newCustomer);
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        if(optionalCustomer.isEmpty()) return false;
        customerRepository.deleteById(id);
        return true;
    }
}
