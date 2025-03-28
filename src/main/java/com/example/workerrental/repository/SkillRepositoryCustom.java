package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.SkillEntity;

public interface SkillRepositoryCustom {
    SkillEntity findOneByName(String name);
}
