package com.example.workerrental.dto;

import java.sql.Date;
import java.util.List;

public class WorkerDTO {
    private String name;
    private String phone;
    private String email;
    private Date dayOfBirth;
    private String address;
    private String gender;
    private String identityCard;
    private String bankAccount;

    private int status;
    private List<WorkerSkillDTO> workerSkillDTOList;

    public String getName() {
        return name;
    }

    public WorkerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public WorkerDTO setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WorkerDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public WorkerDTO setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public WorkerDTO setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public WorkerDTO setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public WorkerDTO setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
        return this;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public WorkerDTO setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public WorkerDTO setStatus(int status) {
        this.status = status;
        return this;
    }

    public List<WorkerSkillDTO> getWorkerSkillDTOList() {
        return workerSkillDTOList;
    }

    public WorkerDTO setWorkerSkillDTOList(List<WorkerSkillDTO> workerSkillDTOList) {
        this.workerSkillDTOList = workerSkillDTOList;
        return this;
    }
}
