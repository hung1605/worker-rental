package com.example.workerrental.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private Email email;
    @Column(name = "dob")
    private Date dob;
    @Column(name = "address")
    private String address;
    @Column(name = "gender")
    private String gender;
    @Column(name = "identityNumber")
    private String identityNumber;
    @Column(name = "status")
    private String status;

    @OneToMany(mappedBy = "worker", cascade = CascadeType.ALL)
    private List<SkillWorkerEntity> skillWorkerEntityList;
}
