package com.example.workerrental.controller;

import com.example.workerrental.model.CustomerDTO;
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
    public ResponseEntity<CustomerDTO>  getCustomerById(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(customerServiceImpl.getCustomerById(id));
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<CustomerDTO>>  getCustomers() {
        return ResponseEntity.ok(customerServiceImpl.getAllCustomers());
    }

    @PostMapping("/api/customer")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServiceImpl.createCustomer(customerDTO));
    }

    @PutMapping("/api/customer")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestParam Integer id, @RequestBody CustomerDTO customerDTO) {
        return ResponseEntity.ok(customerServiceImpl.updateCustomer(id, customerDTO));
    }
    @DeleteMapping("/api/customer")
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam Integer id) {
        return ResponseEntity.ok(customerServiceImpl.deleteCustomer(id));
    }
}
