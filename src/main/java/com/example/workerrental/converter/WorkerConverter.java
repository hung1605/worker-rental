package com.example.workerrental.converter;

import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.repository.entity.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerDTO convertToDTO(Worker entity){
        return modelMapper.map(entity, WorkerDTO.class);
    }

    public Worker converterToEntity(WorkerDTO dto){
        return modelMapper.map(dto, Worker.class);
    }

}
