package com.example.workerrental.converter;

import com.example.workerrental.dto.CustomerContractTaskDTO;
import com.example.workerrental.repository.entity.CustomerContractTaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerContractTaskConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerContractTaskDTO convertToDTO(CustomerContractTaskEntity entity){
        return modelMapper.map(entity, CustomerContractTaskDTO.class);
    }

    public CustomerContractTaskEntity converterToEntity(CustomerContractTaskDTO dto){
        return modelMapper.map(dto, CustomerContractTaskEntity.class);
    }
}
