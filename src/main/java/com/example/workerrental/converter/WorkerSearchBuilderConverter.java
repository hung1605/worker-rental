package com.example.workerrental.converter;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.utils.MapUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class WorkerSearchBuilderConverter {
    public WorkerSearchBuilder toWorkerSearchBuilder(Map<String, String> field, List<String> skillId){
        WorkerSearchBuilder workerSearchBuilder = new WorkerSearchBuilder.Builder()
                .setName(MapUtil.getObject(field,"name", String.class))
                .setPhone(MapUtil.getObject(field,"phone", String.class))
                .setEmail(MapUtil.getObject(field,"email", String.class))
                .setDayOfBirth(MapUtil.getObject(field,"dayOfBirth", java.sql.Date.class))
                .setAddress(MapUtil.getObject(field,"address", String.class))
                .setGender(MapUtil.getObject(field,"gender", String.class))
                .setIdentityCard(MapUtil.getObject(field,"identityCard", String.class))
                .setBankAccount(MapUtil.getObject(field,"bankAccount", String.class))
                .setYearsOfExperienceFrom(MapUtil.getObject(field,"yearsOfExperienceFrom", Float.class))
                .setYearsOfExperienceTo(MapUtil.getObject(field,"yearsOfExperienceTo", Float.class))
                .setSkillId(skillId)
                .setContractStartDate(MapUtil.getObject(field,"contractStartDate", java.sql.Date.class))
                .setContractEndDate(MapUtil.getObject(field,"contractEndDate", java.sql.Date.class))
                .build();
        return workerSearchBuilder;
    }
}
