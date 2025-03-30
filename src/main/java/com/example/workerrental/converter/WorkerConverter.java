package com.example.workerrental.converter;

import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.repository.entity.WorkerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerDTO convertToDTO(WorkerEntity entity){
        return modelMapper.map(entity, WorkerDTO.class);
    }

    public WorkerEntity converterToEntity(WorkerDTO dto){
        return modelMapper.map(dto, WorkerEntity.class);
    }

}
