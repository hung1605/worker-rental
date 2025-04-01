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

    public WorkerEntity() {
    }

    @OneToMany(mappedBy = "workerEntity",cascade =  CascadeType.ALL ,fetch = FetchType.LAZY)
    private List<WorkerSkillEntity> workerSkills = new ArrayList<>();

    @OneToOne(mappedBy = "workerEntity", fetch = FetchType.LAZY)
    private WorkerContractEntity workerContractEntity;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<WorkerSkillEntity> getWorkerSkills() {
        return workerSkills;
    }

    public void setWorkerSkills(List<WorkerSkillEntity> workerSkills) {
        this.workerSkills = workerSkills;
    }

    public WorkerContractEntity getWorkerContractEntity() {
        return workerContractEntity;
    }

    public void setWorkerContractEntity(WorkerContractEntity workerContractEntity) {
        this.workerContractEntity = workerContractEntity;
    }
}
