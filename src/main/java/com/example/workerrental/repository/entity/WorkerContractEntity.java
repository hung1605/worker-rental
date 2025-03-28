package com.example.workerrental.repository.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_worker_contract")
public class WorkerContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "terms")
    private String terms;

    @OneToOne
    @JoinColumn(name = "worker_id")
    private WorkerEntity workerEntity;

    public Long getId() {
        return id;
    }

    public WorkerContractEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public WorkerContractEntity setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public WorkerContractEntity setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getTerms() {
        return terms;
    }

    public WorkerContractEntity setTerms(String terms) {
        this.terms = terms;
        return this;
    }

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public WorkerContractEntity setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
        return this;
    }
}
