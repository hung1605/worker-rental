package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tblWorkerSkill")
public class WorkerSkill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "yearsOfExperience")
    private Float yearsOfExperience;

    @Column(name = "certificate")
    private String certificate;

    @ManyToOne()
    @JoinColumn(name = "skillId")
    private Skill skill;

    @ManyToOne()
    @JoinColumn(name = "workerId")
    private Worker worker;

    public WorkerSkill() {
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

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Worker getWorkerEntity() {
        return worker;
    }

    public void setWorkerEntity(Worker worker) {
        this.worker = worker;
    }
}
