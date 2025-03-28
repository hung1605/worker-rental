package com.example.workerrental.repository.entity;

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
}
