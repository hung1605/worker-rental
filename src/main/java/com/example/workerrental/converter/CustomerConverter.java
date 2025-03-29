package com.example.workerrental.converter;

import com.example.workerrental.model.CustomerDTO;
import com.example.workerrental.model.TaskDTO;
import com.example.workerrental.repository.entity.CustomerEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerDTO convertToDTO(CustomerEntity entity){
        return modelMapper.map(entity, CustomerDTO.class);
    }

    public CustomerEntity converterToEntity(CustomerDTO dto){
        return modelMapper.map(dto, CustomerEntity.class);
    }
}
