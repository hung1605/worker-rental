package com.example.workerrental.model;

import com.example.workerrental.repository.entity.CustomerEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    public CustomerDTO() {

    }

    public CustomerDTO(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public CustomerDTO(CustomerEntity customerEntity) {
        this.name = customerEntity.getName();
        this.phoneNumber = customerEntity.getPhoneNumber();
        this.email = customerEntity.getEmail();
        this.address = customerEntity.getAddress();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
