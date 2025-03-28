package com.example.workerrental.model;

import java.sql.Date;

public class WorkerContractDTO {
    private Date startDate;
    private Date endDate;
    private String terms;
    private WorkerDTO workerDTO;



    public Date getStartDate() {
        return startDate;
    }

    public WorkerContractDTO setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public WorkerContractDTO setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }

    public String getTerms() {
        return terms;
    }

    public WorkerContractDTO setTerms(String terms) {
        this.terms = terms;
        return this;
    }

    public WorkerDTO getWorkerDTO() {
        return workerDTO;
    }

    public WorkerContractDTO setWorkerDTO(WorkerDTO workerDTO) {
        this.workerDTO = workerDTO;
        return this;
    }
}

