package com.example.workerrental.converter;

import com.example.workerrental.dto.WorkerSkillDTO;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerSkillConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerSkillDTO convertToDTO(WorkerSkillEntity entity){
        return modelMapper.map(entity, WorkerSkillDTO.class);
    }

    public WorkerSkillEntity converterToEntity(WorkerSkillDTO dto){
        return modelMapper.map(dto, WorkerSkillEntity.class);
    }
}
