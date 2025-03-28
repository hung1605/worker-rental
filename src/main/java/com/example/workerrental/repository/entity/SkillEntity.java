package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblSkill")
public class SkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "skillEntity", fetch = FetchType.LAZY)
    private List<WorkerSkillEntity> workerSkillEntities =new ArrayList<>();

    public SkillEntity(Long id, String name, String description, List<WorkerSkillEntity> workerSkillEntities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.workerSkillEntities = workerSkillEntities;
    }

    public Long getId() {
        return id;
    }

    public SkillEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SkillEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SkillEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<WorkerSkillEntity> getWorkerSkillEntities() {
        return workerSkillEntities;
    }

    public SkillEntity setWorkerSkillEntities(List<WorkerSkillEntity> workerSkillEntities) {
        this.workerSkillEntities = workerSkillEntities;
        return this;
    }
}
