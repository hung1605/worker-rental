package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "customer_contract_task")
public class CustomerContractTaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "numberOfWorker")
    private int numberOfWorker;


    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "id")
    private TaskEntity taskEntity;

    @ManyToOne
    @JoinColumn(name = "customer_contract_id", referencedColumnName = "id")
    private CustomerContractEntity customerContractEntity;

}
