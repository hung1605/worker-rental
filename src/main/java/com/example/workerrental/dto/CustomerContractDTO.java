package com.example.workerrental.dto;

import java.sql.Date;
import java.util.List;

public class CustomerContractDTO {
    private Date signDay;
    private Date startDay;
    private Date endDay;
    private String terms;
    private Double contractValue;
    private int status;
    private CustomerDTO customerDTO;
    private List<CustomerContractTaskDTO> contractTaskDTOList;

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

    public CustomerDTO getCustomerDTO() {
        return customerDTO;
    }

    public void setCustomerDTO(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<CustomerContractTaskDTO> getContractTaskDTOList() {
        return contractTaskDTOList;
    }

    public void setContractTaskDTOList(List<CustomerContractTaskDTO> contractTaskDTOList) {
        this.contractTaskDTOList = contractTaskDTOList;
    }
}
