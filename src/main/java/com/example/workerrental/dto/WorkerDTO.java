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


    private List<WorkerSkillDTO> workerSkills;

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

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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



    public List<WorkerSkillDTO> getWorkerSkills() {
        return workerSkills;
    }

    public void setWorkerSkills(List<WorkerSkillDTO> workerSkills) {
        this.workerSkills = workerSkills;
    }
}
