package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.Skill;
import com.example.workerrental.repository.entity.Worker;
import com.example.workerrental.repository.entity.WorkerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerSkillRepository extends JpaRepository<WorkerSkill, Long>{
    WorkerSkill findByWorkerAndSkill (Worker worker, Skill skill);
}
