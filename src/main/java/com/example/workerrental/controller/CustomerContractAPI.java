package com.example.workerrental.controller;

import com.example.workerrental.dto.CustomerContractDTO;
import com.example.workerrental.service.impl.CustomerContractServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerContractAPI {
    @Autowired
    CustomerContractServiceImpl customerContractService;
    @PostMapping("api/customer_contract")
    public ResponseEntity<CustomerContractDTO> createCustomerContract(
            @RequestBody CustomerContractDTO customerContractDTO) {
        return ResponseEntity.ok(
                customerContractService.createCustomerContract(customerContractDTO)
        );
    }
}
