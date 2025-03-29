package com.example.workerrental.repository.entity;

import com.example.workerrental.model.CustomerDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tbl_customer")
@AllArgsConstructor
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customerEntity",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<CustomerContractEntity>  customerContractEntityList;


    public CustomerEntity() {

    }

    public CustomerEntity(CustomerDTO customerDTO) {
        this.name = customerDTO.getName();
        this.phoneNumber = customerDTO.getPhoneNumber();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
    }

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
