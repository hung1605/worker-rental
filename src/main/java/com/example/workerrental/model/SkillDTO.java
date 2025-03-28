package com.example.workerrental.model;

public class SkillDTO {
    private String name;
    private String description;


    public String getName() {
        return name;
    }

    public SkillDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SkillDTO setDescription(String description) {
        this.description = description;
        return this;
    }
}
