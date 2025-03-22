package com.example.workerrental.controller;

import com.example.workerrental.model.Customer;
import com.example.workerrental.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerAPI {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    // Xử lý yêu cầu GET tại /api/hello
    @GetMapping("/api/customer")
    public Customer sayHello() {
        return customerServiceImpl.getCustomer();
    }
}
