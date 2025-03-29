package com.example.workerrental.converter;

import com.example.workerrental.model.SkillDTO;
import com.example.workerrental.model.TaskDTO;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SkillDTO convertToDTO(SkillEntity entity){
        return modelMapper.map(entity, SkillDTO.class);
    }

    public SkillEntity converterToEntity(SkillDTO dto){
        return modelMapper.map(dto, SkillEntity.class);
    }
}
