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

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<WorkerSkillEntity> workerSkillEntities =new ArrayList<>();

    public SkillEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<WorkerSkillEntity> getWorkerSkillEntities() {
        return workerSkillEntities;
    }

    public void setWorkerSkillEntities(List<WorkerSkillEntity> workerSkillEntities) {
        this.workerSkillEntities = workerSkillEntities;
    }
}
