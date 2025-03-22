package com.example.workerrental.controller;

import com.example.workerrental.model.Customer;
import com.example.workerrental.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Xử lý yêu cầu GET tại /api/hello
    @GetMapping("/api/customer")
    public Customer sayHello() {
        return customerService.getCustomer();
    }
}
