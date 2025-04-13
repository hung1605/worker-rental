package com.example.workerrental.dto;

import com.example.workerrental.repository.entity.Customer;

import java.sql.Date;

public class CustomerContractStatDTO {
    private Date signDay;
    private Date startDay;
    private Date endDay;
    private String terms;
    private Double contractValue;
    private int status;
    private Customer customer;

    public Date getSignDay() {
        return signDay;
    }

    public void setSignDay(Date signDay) {
        this.signDay = signDay;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Double getContractValue() {
        return contractValue;
    }

    public void setContractValue(Double contractValue) {
        this.contractValue = contractValue;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Customer getCustomerDTO() {
        return customer;
    }

    public void setCustomerDTO(Customer customer) {
        this.customer = customer;
    }
}
