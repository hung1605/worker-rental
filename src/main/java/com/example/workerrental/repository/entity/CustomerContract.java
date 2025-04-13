package com.example.workerrental.repository.entity;

import jakarta.persistence.*;


import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tbl_customer_contract")
public class CustomerContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "signDay")
    private Date signDay;
    @Column(name = "startDay")
    private Date startDay;
    @Column(name = "endDay")
    private Date endDay;
    @Column(name = "terms")
    private String terms;
    @Column(name = "contractValue")
    private Double contractValue;
    @Column(name = "status")
    private int status;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany(mappedBy = "customerContract",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomerContractTask> contractTaskList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<CustomerContractTask> getContractTaskList() {
        return contractTaskList;
    }

    public void setContractTaskList(List<CustomerContractTask> contractTaskList) {
        this.contractTaskList = contractTaskList;
    }
}
