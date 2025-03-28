package com.example.workerrental.repository.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "tblWorker")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @Column(name = "dayOfBirth")
    private Date dayOfBirth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "identityCard")
    private String identityCard;
    @Column(name = "bankAccount")
    private String bankAccount;
    @Column(name = "status")
    private int status;

    @OneToMany(mappedBy = "workerEntity",cascade =  CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<WorkerSkillEntity> workerSkillEntities = new ArrayList<>();

    @OneToOne(mappedBy = "workerEntity", fetch = FetchType.LAZY)
    private WorkerContractEntity workerContractEntity;



    public Long getId() {
        return id;
    }

    public WorkerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public WorkerEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public WorkerEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WorkerEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public WorkerEntity setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public WorkerEntity setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public WorkerEntity setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public WorkerEntity setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public WorkerEntity setStatus(int status) {
        this.status = status;
        return this;
    }

    public List<WorkerSkillEntity> getWorkerSkillEntities() {
        return workerSkillEntities;
    }

    public WorkerEntity setWorkerSkillEntities(List<WorkerSkillEntity> workerSkillEntities) {
        this.workerSkillEntities = workerSkillEntities;
        return this;
    }

    public WorkerContractEntity getWorkerContractEntity() {
        return workerContractEntity;
    }

    public WorkerEntity setWorkerContractEntity(WorkerContractEntity workerContractEntity) {
        this.workerContractEntity = workerContractEntity;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public WorkerEntity setAddress(String address) {
        this.address = address;
        return this;
    }
}