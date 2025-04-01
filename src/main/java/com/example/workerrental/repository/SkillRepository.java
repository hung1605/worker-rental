package com.example.workerrental.repository;

import com.example.workerrental.repository.custom.SkillRepositoryCustom;
import com.example.workerrental.repository.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<SkillEntity, Long> {
    Optional<SkillEntity> findByName(String name);
}
