//package com.example.workerrental.repository.impl;
//
//import com.example.workerrental.repository.custom.WorkerSkillRepositoryCustom;
//
//import com.example.workerrental.repository.entity.WorkerSkillEntity;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import jakarta.persistence.Query;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public class WorkerSkillRepositoryImpl implements WorkerSkillRepositoryCustom {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public WorkerSkillEntity findByWorkerIDAndSkillId(Long workerID, Long skillID) {
//        String sql = "SELECT * FROM tbl_worker_skill as ws WHERE ws.worker_id = '" + workerID + "'" + " AND ws.skill_id = '" + skillID + "'" ;
//        Query query =entityManager.createNativeQuery(sql, WorkerSkillEntity.class);
//        return (WorkerSkillEntity) query.getSingleResult();
//
//    }
//}
