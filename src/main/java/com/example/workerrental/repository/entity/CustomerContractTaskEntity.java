package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tbl_customer_contract_task")
public class CustomerContractTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numberOfWorker")
    private int numberOfWorker;
    @Column(name = "taskCost")
    private double taskCost;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private TaskEntity taskEntity;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id")
    private CustomerContractEntity customerContractEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfWorker() {
        return numberOfWorker;
    }

    public void setNumberOfWorker(int numberOfWorker) {
        this.numberOfWorker = numberOfWorker;
    }

    public double getTaskCost() {
        return taskCost;
    }

    public void setTaskCost(double taskCost) {
        this.taskCost = taskCost;
    }

    public TaskEntity getTaskEntity() {
        return taskEntity;
    }

    public void setTaskEntity(TaskEntity taskEntity) {
        this.taskEntity = taskEntity;
    }

    public CustomerContractEntity getCustomerContractEntity() {
        return customerContractEntity;
    }

    public void setCustomerContractEntity(CustomerContractEntity customerContractEntity) {
        this.customerContractEntity = customerContractEntity;
    }
}
