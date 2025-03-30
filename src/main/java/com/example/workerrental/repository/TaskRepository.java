package com.example.workerrental.repository;

import com.example.workerrental.repository.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    TaskEntity findByName(String name);
}
