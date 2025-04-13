package com.example.workerrental.repository.impl;

import com.example.workerrental.repository.custom.SkillRepositoryCustom;
import com.example.workerrental.repository.entity.Skill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class SkillRepositoryImpl implements SkillRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    //Sử dụng hàm này khi chưa biết id của SkillEntity
    @Override
    public Skill findOneByName(String name) {
        String sql = "SELECT * FROM tblSkill as s WHERE s.name = '" + name + "'";
        Query query =entityManager.createNativeQuery(sql, Skill.class);
        return (Skill) query.getSingleResult();
    }
}
