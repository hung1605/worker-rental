package com.example.workerrental.converter;

import com.example.workerrental.dto.CustomerContractDTO;
import com.example.workerrental.repository.entity.CustomerContractEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerContractConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CustomerContractDTO convertToDTO(CustomerContractEntity entity){
        return modelMapper.map(entity, CustomerContractDTO.class);
    }

    public CustomerContractEntity converterToEntity(CustomerContractDTO dto){
        return modelMapper.map(dto, CustomerContractEntity.class);
    }
}
