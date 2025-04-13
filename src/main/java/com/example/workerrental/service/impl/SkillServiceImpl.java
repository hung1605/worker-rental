package com.example.workerrental.service.impl;

import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.entity.Skill;
import com.example.workerrental.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository skillRepository;
    @Override
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }
}
