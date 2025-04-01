package com.example.workerrental.dto;

import java.sql.Date;

public class WorkerContractDTO {
    private Date startDate;
    private Date endDate;
    private String terms;
    private WorkerDTO workerDTO;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public WorkerDTO getWorkerDTO() {
        return workerDTO;
    }

    public void setWorkerDTO(WorkerDTO workerDTO) {
        this.workerDTO = workerDTO;
    }
}

