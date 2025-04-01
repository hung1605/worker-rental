package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerSkillRepository extends JpaRepository<WorkerSkillEntity, Long>{
    WorkerSkillEntity findByWorkerEntityAndSkill(WorkerEntity worker, SkillEntity skill);
}
