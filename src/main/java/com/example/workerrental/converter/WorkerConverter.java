package com.example.workerrental.converter;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.repository.entity.WorkerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerDTO convertToDTO(WorkerEntity entity){
        WorkerDTO result = modelMapper.map(entity, WorkerDTO.class);
        return result;
    }

    public WorkerEntity converterToEntity(WorkerDTO dto){
        WorkerEntity result = modelMapper.map(dto, WorkerEntity.class);
        return result;
    }

}
