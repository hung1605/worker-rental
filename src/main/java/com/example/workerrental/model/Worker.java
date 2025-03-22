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
}
