package com.example.workerrental.service.impl;

import com.example.workerrental.converter.CustomerContractConverter;
import com.example.workerrental.converter.CustomerContractTaskConverter;
import com.example.workerrental.converter.CustomerConverter;
import com.example.workerrental.converter.TaskConverter;
import com.example.workerrental.dto.CustomerContractDTO;
import com.example.workerrental.dto.CustomerContractTaskDTO;
import com.example.workerrental.repository.CustomerContractRepository;
import com.example.workerrental.repository.CustomerRepository;
import com.example.workerrental.repository.TaskRepository;
import com.example.workerrental.repository.entity.CustomerContractEntity;
import com.example.workerrental.repository.entity.CustomerContractTaskEntity;
import com.example.workerrental.repository.entity.CustomerEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import com.example.workerrental.service.CustomerContractService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerContractServiceImpl implements CustomerContractService {

    private final CustomerContractRepository customerContractRepository;
    private final CustomerRepository customerRepository;
    private final CustomerContractRepository customerContractTaskRepository;
    private final TaskRepository taskRepository;

    private final CustomerContractConverter customerContractConverter;
    private final CustomerContractTaskConverter customerContractTaskConverter;
    private final TaskConverter taskConverter;
    private final CustomerConverter customerConverter;

    public CustomerContractServiceImpl(CustomerContractRepository customerContractRepository,
                                       CustomerRepository customerRepository,
                                       CustomerContractRepository customerContractTaskRepository,
                                       TaskRepository taskRepository,
                                       CustomerContractConverter customerContractConverter,
                                       CustomerContractTaskConverter customerContractTaskConverter,
                                       TaskConverter taskConverter,
                                       CustomerConverter customerConverter) {
        this.customerContractRepository = customerContractRepository;
        this.customerRepository = customerRepository;
        this.customerContractTaskRepository = customerContractTaskRepository;
        this.taskRepository = taskRepository;
        this.customerContractConverter = customerContractConverter;
        this.customerContractTaskConverter = customerContractTaskConverter;
        this.taskConverter = taskConverter;
        this.customerConverter = customerConverter;
    }
    @Override
    public CustomerContractDTO createCustomerContract(CustomerContractDTO customerContractDTO) {
        // convert from dto -> entity
        CustomerContractEntity customerContractEntity =
                customerContractConverter.converterToEntity(customerContractDTO);
        CustomerEntity customerEntity = customerRepository.findByPhoneNumber(customerContractDTO.getCustomerDTO().getPhoneNumber());
        List<CustomerContractTaskEntity> list = customerContractDTO.getContractTaskDTOList().stream()
                .map(customerContractTaskDTO -> {
                    TaskEntity taskEntity = taskRepository.findByName(customerContractTaskDTO.getTaskDTO().getName());
                    CustomerContractTaskEntity customerContractTaskEntity =
                            customerContractTaskConverter.converterToEntity(customerContractTaskDTO);
                    customerContractTaskEntity.setTaskEntity(taskEntity);
                    customerContractTaskEntity.setCustomerContractEntity(customerContractEntity);
                    return customerContractTaskEntity;
                })
                .toList();

        customerContractEntity.setCustomerEntity(customerEntity);
        customerContractEntity.setContractTaskEntityList(list);

        // saving
        CustomerContractEntity savedCustomerContractEntity = customerContractRepository.save(customerContractEntity);

        // convert from entity -> dto
        CustomerContractDTO responseCustomerContractDTO
                = customerContractConverter.convertToDTO(savedCustomerContractEntity);
        responseCustomerContractDTO.setContractTaskDTOList(new ArrayList<>());
        responseCustomerContractDTO.setCustomerDTO(customerConverter.convertToDTO(customerEntity));
        list.forEach(customerContractTaskEntity -> {
            CustomerContractTaskDTO customerContractTaskDTO = customerContractTaskConverter.convertToDTO(customerContractTaskEntity);
            responseCustomerContractDTO.getContractTaskDTOList().add(customerContractTaskDTO);
            customerContractTaskDTO.setTaskDTO(taskConverter.convertToDTO(customerContractTaskEntity.getTaskEntity()));
        });
        return responseCustomerContractDTO;
    }

}
