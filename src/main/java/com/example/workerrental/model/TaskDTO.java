package com.example.workerrental.model;

import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import jakarta.persistence.*;

public class TaskDTO {
    private String name;
    private String description;
    private Double salary;
    private String unit;
    private boolean state;
    private SkillEntity skillEntity;

    public TaskDTO() {
    }

    public TaskDTO(String name, String description, Double salary, String unit, boolean state, SkillEntity skillEntity) {
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.unit = unit;
        this.state = state;
        this.skillEntity = skillEntity;
    }

    public TaskDTO(TaskEntity taskEntity) {
        this.name = taskEntity.getName();
        this.description = taskEntity.getDescription();
        this.salary = taskEntity.getSalary();
        this.unit = taskEntity.getUnit();
        this.state = taskEntity.isState();
        this.skillEntity = taskEntity.getSkillEntity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public SkillEntity getSkillEntity() {
        return skillEntity;
    }

    public void setSkillEntity(SkillEntity skillEntity) {
        this.skillEntity = skillEntity;
    }
}
