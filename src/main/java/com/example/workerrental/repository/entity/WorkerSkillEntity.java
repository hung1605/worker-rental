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

    @ManyToOne()
    @JoinColumn(name = "skillId")
    private SkillEntity skill;

    @ManyToOne()
    @JoinColumn(name = "workerId")
    private WorkerEntity workerEntity;

    public WorkerSkillEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public SkillEntity getSkill() {
        return skill;
    }

    public void setSkill(SkillEntity skill) {
        this.skill = skill;
    }

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }
}
