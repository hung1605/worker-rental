package com.example.workerrental.repository.entity;

import com.example.workerrental.model.TaskDTO;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "salary")
    private Double salary;
    @Column(name = "unit")
    private String unit;
    @Column(name = "state")
    private boolean state;

    @OneToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private SkillEntity skillEntity;

    public TaskEntity() {
    }

    public TaskEntity(TaskDTO taskDTO) {
        this.name = taskDTO.getName();
        this.description = taskDTO.getDescription();
        this.salary = taskDTO.getSalary();
        this.unit = taskDTO.getUnit();
        this.state = taskDTO.isState();
        this.skillEntity = taskDTO.getSkillEntity();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
