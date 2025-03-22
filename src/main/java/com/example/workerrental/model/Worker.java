package com.example.workerrental.model;

import jakarta.validation.constraints.Email;

import java.util.Date;

public class Worker {
    private String name;
    private String phoneNumber;
    private Email email;
    private Date dob;
    private String address;
    private String gender;
    private String identityNumber;
    private String status;

    public Worker() {
    }

    public Worker(String name, String phoneNumber, Email email, Date dob, String address, String gender, String identityNumber, String status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public Worker setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Worker setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public Email getEmail() {
        return email;
    }

    public Worker setEmail(Email email) {
        this.email = email;
        return this;
    }

    public Date getDob() {
        return dob;
    }

    public Worker setDob(Date dob) {
        this.dob = dob;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Worker setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Worker setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public Worker setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Worker setStatus(String status) {
        this.status = status;
        return this;
    }
}
