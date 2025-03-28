package com.example.workerrental.repository.impl;

import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.SkillRepositoryCustom;
import com.example.workerrental.repository.entity.SkillEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepositoryImpl implements SkillRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public SkillEntity findOneByName(String name) {
        String sql = "SELECT * FROM tbl_skill as s WHERE s.name = '" + name + "'";
        Query query =entityManager.createNativeQuery(sql, SkillEntity.class);
        System.out.println(query.getSingleResult());
        return (SkillEntity) query.getSingleResult();
    }
}
