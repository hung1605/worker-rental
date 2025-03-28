package com.example.workerrental.model;

public class WorkerSkillDTO {
    private Float yearsOfExperience;
    private String certificate;
    private SkillDTO skillDTO;


    public Float getYearsOfExperience() {
        return yearsOfExperience;
    }

    public WorkerSkillDTO setYearsOfExperience(Float yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
        return this;
    }

    public String getCertificate() {
        return certificate;
    }

    public WorkerSkillDTO setCertificate(String certificate) {
        this.certificate = certificate;
        return this;
    }

    public SkillDTO getSkillDTO() {
        return skillDTO;
    }

    public WorkerSkillDTO setSkillDTO(SkillDTO skillDTO) {
        this.skillDTO = skillDTO;
        return this;
    }
}
