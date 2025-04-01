package com.example.workerrental.repository.custom;

import com.example.workerrental.repository.entity.SkillEntity;

public interface SkillRepositoryCustom {
    SkillEntity findOneByName(String name);
}
