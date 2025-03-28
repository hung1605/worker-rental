package com.example.workerrental.converter;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.model.WorkerSkillDTO;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerSkillConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerSkillDTO convertToDTO(WorkerSkillEntity entity){
        WorkerSkillDTO result = modelMapper.map(entity, WorkerSkillDTO.class);
        return result;
    }

    public WorkerSkillEntity converterToEntity(WorkerSkillDTO dto){
        WorkerSkillEntity result = modelMapper.map(dto, WorkerSkillEntity.class);
        return result;
    }
}
