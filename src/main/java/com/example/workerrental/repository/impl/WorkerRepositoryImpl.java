package com.example.workerrental.repository.impl;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.repository.custom.WorkerRepositoryCustom;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.sql.Date;
import java.util.*;
import java.util.stream.Collectors;
@Repository
public class WorkerRepositoryImpl implements WorkerRepositoryCustom{
    @PersistenceContext
    private EntityManager entityManager;

    public static void joinTable(WorkerSearchBuilder workerSearchBuilder, StringBuilder sql){
        Boolean isJoin = false;
        List<String> skillId = workerSearchBuilder.getSkillId();
        if(skillId != null && skillId.size()>0){
            isJoin = true;
            sql.append(" INNER JOIN tblworkerskill ws ON w.id = ws.workerId ");
            sql.append(" INNER JOIN tblskill s ON s.id = ws.skillId ");
        }
        Float yearsOfExperienceFrom = workerSearchBuilder.getYearsOfExperienceFrom();
        Float yearsOfExperienceTo = workerSearchBuilder.getYearsOfExperienceTo();
        if(isJoin==false){
            if(yearsOfExperienceFrom != null || yearsOfExperienceTo != null){
                sql.append(" INNER JOIN tblworkerskill ws ON w.id = ws.workerId ");
            }
        }
        Date contractStartDate = workerSearchBuilder.getContractStartDate();
        Date contractEndDate = workerSearchBuilder.getContractEndDate();
        if(contractStartDate != null || contractEndDate != null){
            sql.append(" INNER JOIN tblworkercontract wc ON w.id = wc.workerId ");
        }
    }

    public static void querryNormal(WorkerSearchBuilder workerSearchBuilder, StringBuilder where){
        try{
            Field[] fields = WorkerSearchBuilder.class.getDeclaredFields();
            for(Field item:fields){
                item.setAccessible(true);
                String fieldName = item.getName();
                if(!fieldName.equals("skillId") && !fieldName.startsWith("yearsOfExperience") && !fieldName.startsWith("contract")){
                    Object value =  item.get(workerSearchBuilder);
                    if(value != null && !value.toString().isEmpty()){
                        where.append(" AND w." + fieldName + " LIKE '%" + value + "%' ");
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void querrySpecial(WorkerSearchBuilder workerSearchBuilder, StringBuilder where){
        Float yearsOfExperienceFrom = workerSearchBuilder.getYearsOfExperienceFrom();
        Float yearsOfExperienceTo = workerSearchBuilder.getYearsOfExperienceTo();
            if(yearsOfExperienceFrom != null){
                where.append(" AND ws.yearsOfExperience >= " + yearsOfExperienceFrom);
            }
            if(yearsOfExperienceTo != null){
                where.append(" AND ws.yearsOfExperience <= " + yearsOfExperienceTo);
            }

        Date contractStartDate = workerSearchBuilder.getContractStartDate();
        Date contractEndDate = workerSearchBuilder.getContractEndDate();
        if(contractStartDate != null){
            where.append(" AND wc.startDate >= '" + contractStartDate + "' ");
        }
        if(contractEndDate != null){
            where.append(" AND wc.startDate <= '" + contractEndDate + "' ");
        }

        List<String> skillId = workerSearchBuilder.getSkillId();
        if(skillId!=null && skillId.size()>0){
            String id = skillId.stream().map(it -> "'" + it + "'").collect(Collectors.joining(","));
            where.append(" AND ws.skillId IN(" + id + ")");
        }
        where.append(" GROUP BY w.id ");
    }

    @Override
    public List<WorkerEntity> searchWorker(WorkerSearchBuilder workerSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT w.* FROM tblworker w");
        StringBuilder where = new StringBuilder(" WHERE w.status = 1 ");
        joinTable(workerSearchBuilder, sql);
        querryNormal(workerSearchBuilder, where);
        querrySpecial(workerSearchBuilder, where);
        sql.append(where);
        Query query = entityManager.createNativeQuery(sql.toString(), WorkerEntity.class);
        List<WorkerEntity> result = query.getResultList();
        return result;
    }
}
