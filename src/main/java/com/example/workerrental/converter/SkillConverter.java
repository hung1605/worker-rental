package com.example.workerrental.converter;

import com.example.workerrental.dto.SkillDTO;
import com.example.workerrental.repository.entity.SkillEntity;
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
