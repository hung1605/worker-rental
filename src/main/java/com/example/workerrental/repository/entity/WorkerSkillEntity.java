package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tbl_worker_skill")
public class WorkerSkillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yearsOfExperience")
    private Float yearsOfExperience;

    @Column(name = "certificate")
    private String certificate;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private SkillEntity skillEntity;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity workerEntity;



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
