package com.example.workerrental.repository.custom;

import com.example.workerrental.repository.entity.Skill;

public interface SkillRepositoryCustom {
    Skill findOneByName(String name);
}
