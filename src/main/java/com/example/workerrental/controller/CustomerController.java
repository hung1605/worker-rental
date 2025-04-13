package com.example.workerrental.controller;

import com.example.workerrental.repository.entity.Customer;
import com.example.workerrental.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @GetMapping("/api/customer")
    public ResponseEntity<Customer>  getCustomerById(@RequestParam(name = "id") Long id) {
        return ResponseEntity.ok(customerServiceImpl.getCustomerById(id));
    }

    @GetMapping("/api/customers")
    public ResponseEntity<List<Customer>>  getAllCustomers() {
        return ResponseEntity.ok(customerServiceImpl.getAllCustomers());
    }

    @PostMapping("/api/customer")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerServiceImpl.createCustomer(customer));
    }

    @PutMapping("/api/customer")
    public ResponseEntity<Customer> updateCustomer(@RequestParam Long id, @RequestBody Customer customer) {
        return ResponseEntity.ok(customerServiceImpl.updateCustomer(id, customer));
    }
    @DeleteMapping("/api/customer")
    public ResponseEntity<Boolean> deleteCustomer(@RequestParam Long id) {
        return ResponseEntity.ok(customerServiceImpl.deleteCustomer(id));
    }
}
