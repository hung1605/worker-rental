package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "customer_contract")
public class CustomerContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "signDay")
    private Date signDay;
    @Column(name = "startDay")
    private Date startDay;
    @Column(name = "endDay")
    private Date endDay;
    @Column(name = "clause")
    private String clause;
    @Column(name = "contractValue")
    private Double contractValue;
    @Column(name = "state")
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private CustomerEntity customerEntity;

    @OneToMany(mappedBy = "customerContractEntity", cascade = CascadeType.ALL)
    private List<CustomerContractTaskEntity> contractTaskEntityList;



}
