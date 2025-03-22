package com.example.workerrental.service.impl;

import com.example.workerrental.model.Customer;
import com.example.workerrental.repository.CustomerRepository;
import com.example.workerrental.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    // Logic xử lý nghiệp vụ, trả về thông tin khách hàng

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer getCustomer() {
        // Logic lấy dữ liệu khách hàng, ví dụ ở đây là mock data
        return customerRepository.getCustomer();
    }
}
