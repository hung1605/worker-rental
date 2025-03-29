package com.example.workerrental.converter;

import com.example.workerrental.model.TaskDTO;
import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.repository.entity.TaskEntity;
import com.example.workerrental.repository.entity.WorkerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter {
    @Autowired
    private ModelMapper modelMapper;

    public TaskDTO convertToDTO(TaskEntity entity){
        return modelMapper.map(entity, TaskDTO.class);
    }

    public TaskEntity converterToEntity(TaskDTO dto){
        return modelMapper.map(dto, TaskEntity.class);
    }
}
