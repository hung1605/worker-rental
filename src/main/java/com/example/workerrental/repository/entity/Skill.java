package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tblSkill")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    private List<WorkerSkill> workerSkills =new ArrayList<>();

    public Skill() {
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

    public List<WorkerSkill> getWorkerSkills() {
        return workerSkills;
    }

    public void setWorkerSkills(List<WorkerSkill> workerSkills) {
        this.workerSkills = workerSkills;
    }
}
