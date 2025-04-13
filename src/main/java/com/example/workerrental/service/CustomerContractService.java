package com.example.workerrental.service;

import com.example.workerrental.dto.CustomerContractStatDTO;
import com.example.workerrental.repository.entity.CustomerContract;

import java.util.List;

public interface CustomerContractService {
    CustomerContract createCustomerContract (CustomerContract customerContractDTO);
    List<CustomerContract> getCustomerContractByCustomer(Long customerId);
    List<CustomerContractStatDTO> getALlCustomerContract();
}
