package com.example.workerrental.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_customer_contract_task")
public class CustomerContractTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numberOfWorker")
    private int numberOfWorker;
    @Column(name = "taskCost")
    private double taskCost;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id")
    private CustomerContract customerContract;

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

    public Task getTaskEntity() {
        return task;
    }

    public void setTaskEntity(Task task) {
        this.task = task;
    }

    public CustomerContract getCustomerContractEntity() {
        return customerContract;
    }

    public void setCustomerContractEntity(CustomerContract customerContract) {
        this.customerContract = customerContract;
    }
}
