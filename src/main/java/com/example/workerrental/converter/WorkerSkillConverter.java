package com.example.workerrental.converter;

import com.example.workerrental.dto.WorkerSkillDTO;
import com.example.workerrental.repository.entity.WorkerSkill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkerSkillConverter {
    @Autowired
    private ModelMapper modelMapper;

    public WorkerSkillDTO convertToDTO(WorkerSkill entity){
        return modelMapper.map(entity, WorkerSkillDTO.class);
    }

    public WorkerSkill converterToEntity(WorkerSkillDTO dto){
        return modelMapper.map(dto, WorkerSkill.class);
    }
}
