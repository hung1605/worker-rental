package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tblWorkerSkill")
public class WorkerSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yearsOfExperience")
    private Float yearsOfExperience;

    @Column(name = "certificate")
    private String certificate;

    @ManyToOne
    @JoinColumn(name = "skillId")
    private SkillEntity skillEntity;

    @ManyToOne
    @JoinColumn(name = "workerId")
    private WorkerEntity workerEntity;

    public WorkerSkillEntity(Long id, Float yearsOfExperience, String certificate, SkillEntity skillEntity, WorkerEntity workerEntity) {
        this.id = id;
        this.yearsOfExperience = yearsOfExperience;
        this.certificate = certificate;
        this.skillEntity = skillEntity;
        this.workerEntity = workerEntity;
    }

    public Long getId() {
        return id;
    }

    public WorkerSkillEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public WorkerSkillEntity setYearsOfExperience(Float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
        return this;
    }

    public String getCertificate() {
        return certificate;
    }

    public WorkerSkillEntity setCertificate(String certificate) {
        this.certificate = certificate;
        return this;
    }

    public SkillEntity getSkillEntity() {
        return skillEntity;
    }

    public WorkerSkillEntity setSkillEntity(SkillEntity skillEntity) {
        this.skillEntity = skillEntity;
        return this;
    }

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public WorkerSkillEntity setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
        return this;
    }
}
