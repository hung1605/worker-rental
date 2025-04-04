package com.example.workerrental.controller;

import com.example.workerrental.dto.CustomerDTO;
import com.example.workerrental.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerAPI {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/api/customer")
    public ResponseEntity<CustomerDTO>  getCustomerById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(customerServiceImpl.getCustomerById(id));
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<CustomerDTO>>  getAllCustomers() {
        return ResponseEntity.ok(customerServiceImpl.getAllCustomers());
    }

    @PostMapping("/api/customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServiceImpl.createCustomer(customerDTO));
    }

    @PutMapping("/api/customer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestParam Long id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServiceImpl.updateCustomer(id, customerDTO));
    }
    @DeleteMapping("/api/customer")
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam Long id) {
        return ResponseEntity.ok(customerServiceImpl.deleteCustomer(id));
    }
}
