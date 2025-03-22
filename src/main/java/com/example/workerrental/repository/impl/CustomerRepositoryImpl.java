package com.example.workerrental.repository.impl;

import com.example.workerrental.model.Customer;
import com.example.workerrental.repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer getCustomer() {
        return new Customer(1,
                "viet hung",
                "0823210088",
                "johndoe@example.com",
                "abc.xyz.hanoi" );
    }
}
