package com.example.workerrental.converter;

import com.example.workerrental.dto.SkillDTO;
import com.example.workerrental.repository.entity.Skill;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillConverter {
    @Autowired
    private ModelMapper modelMapper;

    public SkillDTO convertToDTO(Skill entity){
        return modelMapper.map(entity, SkillDTO.class);
    }

    public Skill converterToEntity(SkillDTO dto){
        return modelMapper.map(dto, Skill.class);
    }
}
