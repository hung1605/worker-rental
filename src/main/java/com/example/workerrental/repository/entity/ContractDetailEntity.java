package com.example.workerrental.repository.entity;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "tbl_contract_detail")
public class ContractDetailEntity {
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
    private WorkerEntity workerEntity ;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id")
    private CustomerContractEntity customerContractEntity;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

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

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }

    public CustomerContractEntity getCustomerContractEntity() {
        return customerContractEntity;
    }

    public void setCustomerContractEntity(CustomerContractEntity customerContractEntity) {
        this.customerContractEntity = customerContractEntity;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }
}
