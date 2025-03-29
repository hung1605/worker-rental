package com.example.workerrental.model;

public class TaskDTO {
    private String name;
    private String description;
    private Double salary;
    private String unit;
    private int status;
    private SkillDTO skillEntity;

    public TaskDTO() {
    }

    public TaskDTO(String name,
                   String description,
                   Double salary,
                   String unit,
                   int status,
                   SkillDTO skillEntity) {
        this.name = name;
        this.description = description;
        this.salary = salary;
        this.unit = unit;
        this.status = status;
        this.skillEntity = skillEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public SkillDTO getSkillEntity() {
        return skillEntity;
    }

    public void setSkillEntity(SkillDTO skillEntity) {
        this.skillEntity = skillEntity;
    }
}
