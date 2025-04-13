package com.example.workerrental.service.impl;


import com.example.workerrental.dto.CustomerContractStatDTO;
import com.example.workerrental.repository.CustomerContractRepository;
import com.example.workerrental.repository.CustomerRepository;
import com.example.workerrental.repository.entity.Customer;
import com.example.workerrental.repository.entity.CustomerContract;
import com.example.workerrental.service.CustomerContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerContractServiceImpl implements CustomerContractService {

    @Autowired
    private CustomerContractRepository customerContractRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerContract createCustomerContract(CustomerContract contract) {
        return customerContractRepository.save(contract);
    }

    @Override
    public List<CustomerContract> getCustomerContractByCustomer(Long customerId) {
        Optional<Customer> optional = customerRepository.findById(customerId);
        if(optional.isEmpty()) throw new RuntimeException("can not find id");
        Customer customer = optional.get();
        return customer.getCustomerContractList();
    }

    @Override
    public List<CustomerContractStatDTO> getALlCustomerContract() {

        List<CustomerContract> entityList = customerContractRepository.findAll();
        List<CustomerContractStatDTO> dtoList = new ArrayList<>();

        entityList.forEach(customerContract -> {
            CustomerContractStatDTO dto = new CustomerContractStatDTO();

            dto.setSignDay(customerContract.getSignDay());
            dto.setStartDay(customerContract.getStartDay());
            dto.setEndDay(customerContract.getEndDay());
            dto.setTerms(customerContract.getTerms());
            dto.setContractValue(customerContract.getContractValue());
            dto.setStatus(customerContract.getStatus());
            dto.setCustomerDTO(customerContract.getCustomer());
            dtoList.add(dto);
        });
        return dtoList;
    }

}
