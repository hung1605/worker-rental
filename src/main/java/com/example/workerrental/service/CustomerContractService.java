package com.example.workerrental.service;

import com.example.workerrental.dto.CustomerContractDTO;
import com.example.workerrental.repository.entity.CustomerContractEntity;

public interface CustomerContractService {
    CustomerContractDTO createCustomerContract (CustomerContractDTO customerContractDTO);
}
