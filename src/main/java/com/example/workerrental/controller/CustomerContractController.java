package com.example.workerrental.controller;

import com.example.workerrental.dto.CustomerContractStatDTO;
import com.example.workerrental.repository.entity.CustomerContract;
import com.example.workerrental.service.impl.CustomerContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerContractController {
    @Autowired
    CustomerContractServiceImpl customerContractService;

    @PostMapping("api/customer_contract")
    public ResponseEntity<CustomerContract> createCustomerContract(
            @RequestBody CustomerContract customerContract) {
        return ResponseEntity.ok(
                customerContractService.createCustomerContract(customerContract)
        );
    }

    @GetMapping("api/customer_contracts")
    public ResponseEntity<List<CustomerContract>> getCustomerContractByCustomerId(
            @RequestParam(name = "customerId") Long customerId) {
        return ResponseEntity.ok(
                customerContractService.getCustomerContractByCustomer(customerId)
        );
    }

    @GetMapping("api/all_customer_contracts")
    public ResponseEntity<List<CustomerContractStatDTO>> getALlCustomerContract() {
        return ResponseEntity.ok(
                customerContractService.getALlCustomerContract()
        );
    }
}
