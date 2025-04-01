package com.example.workerrental.builder;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class WorkerSearchBuilder {
    private String name;
    private String phone;
    private String email;
    private Date dayOfBirth;
    private String address;
    private String gender;
    private String identityCard;
    private String bankAccount;

    private Float yearsOfExperienceFrom;
    private Float yearsOfExperienceTo;
    private List<String> skillId = new ArrayList<>();
    private Date contractStartDate;
    private Date contractEndDate;

    public WorkerSearchBuilder(Builder builder) {
        this.name = builder.name;
        this.phone = builder.phone;
        this.email = builder.email;
        this.dayOfBirth = builder.dayOfBirth;
        this.address = builder.address;
        this.gender = builder.gender;
        this.identityCard = builder.identityCard;
        this.bankAccount = builder.bankAccount;
        this.yearsOfExperienceFrom = builder.yearsOfExperienceFrom;
        this.yearsOfExperienceTo = builder.yearsOfExperienceTo;
        this.skillId = builder.skillId;
        this.contractStartDate = builder.contractStartDate;
        this.contractEndDate = builder.contractEndDate;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public Float getYearsOfExperienceFrom() {
        return yearsOfExperienceFrom;
    }

    public Float getYearsOfExperienceTo() {
        return yearsOfExperienceTo;
    }

    public List<String> getSkillId() {
        return skillId;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public static class Builder{
        private String name;
        private String phone;
        private String email;
        private Date dayOfBirth;
        private String address;
        private String gender;
        private String identityCard;
        private String bankAccount;

        private Float yearsOfExperienceFrom;
        private Float yearsOfExperienceTo;
        private List<String> skillId = new ArrayList<>();
        private Date contractStartDate;
        private Date contractEndDate;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setDayOfBirth(Date dayOfBirth) {
            this.dayOfBirth = dayOfBirth;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setIdentityCard(String identityCard) {
            this.identityCard = identityCard;
            return this;
        }

        public Builder setBankAccount(String bankAccount) {
            this.bankAccount = bankAccount;
            return this;
        }

        public Builder setYearsOfExperienceFrom(Float yearsOfExperienceFrom) {
            this.yearsOfExperienceFrom = yearsOfExperienceFrom;
            return this;
        }

        public Builder setYearsOfExperienceTo(Float yearsOfExperienceTo) {
            this.yearsOfExperienceTo = yearsOfExperienceTo;
            return this;
        }

        public Builder setSkillId(List<String> skillId) {
            this.skillId = skillId;
            return this;
        }

        public Builder setContractStartDate(Date contractStartDate) {
            this.contractStartDate = contractStartDate;
            return this;
        }

        public Builder setContractEndDate(Date contractEndDate) {
            this.contractEndDate = contractEndDate;
            return this;
        }
        public WorkerSearchBuilder build() {
            return new WorkerSearchBuilder(this);
        }
    }

}
