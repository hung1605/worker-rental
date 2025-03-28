package com.example.workerrental.model;

import jakarta.validation.constraints.Email;

import java.util.Date;
import java.util.List;

public class WorkerDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private Date dayOfbirth;
    private String address;
    private String gender;
    private String identityNumber;
    private int status;
    private List<WorkerSkillDTO> workerSkillDTOList;
    public WorkerDTO() {
    }



    public String getName() {
        return name;
    }

    public WorkerDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public WorkerDTO setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public WorkerDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public WorkerDTO setStatus(int status) {
        this.status = status;
        return this;
    }

    public Date getDayOfbirth() {
        return dayOfbirth;
    }

    public WorkerDTO setDayOfbirth(Date dayOfbirth) {
        this.dayOfbirth = dayOfbirth;
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

    public String getIdentityNumber() {
        return identityNumber;
    }

    public WorkerDTO setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
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
