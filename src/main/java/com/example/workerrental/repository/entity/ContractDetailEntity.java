package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "contract_detail")
public class ContractDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "startWorkingDay")
    private Date startWorkingDay;
    @Column(name = "endWorkingDay")
    private Date endWorkingDay;
    @Column(name = "numberOfWorkingDays")
    private int numberOfWorkingDays;
    @Column(name = "late")
    private int late;
    @Column(name = "absent")
    private int absent;
    @Column(name = "violate")
    private int violate;
    @Column(name = "reward")
    private double reward;
    @Column(name = "wage")
    private int wage;

    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private WorkerEntity workerEntity ;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id", referencedColumnName = "id")
    private CustomerContractEntity customerContractEntity;

    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity taskEntity;
}
