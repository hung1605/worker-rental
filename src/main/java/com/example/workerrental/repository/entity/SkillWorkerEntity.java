package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "skill_worker")
public class SkillWorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "yearsOfExperient")
    private int yearsOfExperient;
    @Column(name = "certificate")
    private String certificate;

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "id")
    private SkillEntity skillEntity;
    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private WorkerEntity workerEntity;
}
