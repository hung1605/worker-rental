package com.example.workerrental.repository.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "startWorkingDay")
    private Date startWorkingDay;
    @Column(name = "endWorkingDay")
    private Date endWorkingDay;
    @Column(name = "numberOfWorkingDays")
    private int numberOfWorkingDays;
    @Column(name = "lateCount")
    private int lateCount;
    @Column(name = "absent")
    private int absent;
    @Column(name = "violate")
    private int violate;
    @Column(name = "reward")
    private double reward;
    @Column(name = "wage")
    private double wage;

    @ManyToOne
    @JoinColumn(name = "worker_id")
    private Worker worker;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id")
    private CustomerContract customerContract;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStartWorkingDay() {
        return startWorkingDay;
    }

    public void setStartWorkingDay(Date startWorkingDay) {
        this.startWorkingDay = startWorkingDay;
    }

    public Date getEndWorkingDay() {
        return endWorkingDay;
    }

    public void setEndWorkingDay(Date endWorkingDay) {
        this.endWorkingDay = endWorkingDay;
    }

    public int getNumberOfWorkingDays() {
        return numberOfWorkingDays;
    }

    public void setNumberOfWorkingDays(int numberOfWorkingDays) {
        this.numberOfWorkingDays = numberOfWorkingDays;
    }

    public int getLateCount() {
        return lateCount;
    }

    public void setLateCount(int lateCount) {
        this.lateCount = lateCount;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public int getViolate() {
        return violate;
    }

    public void setViolate(int violate) {
        this.violate = violate;
    }

    public double getReward() {
        return reward;
    }

    public void setReward(double reward) {
        this.reward = reward;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public Worker getWorkerEntity() {
        return worker;
    }

    public void setWorkerEntity(Worker worker) {
        this.worker = worker;
    }

    public CustomerContract getCustomerContractEntity() {
        return customerContract;
    }

    public void setCustomerContractEntity(CustomerContract customerContract) {
        this.customerContract = customerContract;
    }

    public Task getTaskEntity() {
        return task;
    }

    public void setTaskEntity(Task task) {
        this.task = task;
    }
}
