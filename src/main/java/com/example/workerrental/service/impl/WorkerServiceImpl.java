package com.example.workerrental.service.impl;

import com.example.workerrental.converter.WorkerConverter;
import com.example.workerrental.converter.WorkerSkillConverter;
import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.dto.WorkerSkillDTO;
import com.example.workerrental.repository.SkillRepositoryCustom;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private WorkerConverter workerConverter;
    @Autowired
    private WorkerSkillConverter workerSkillConverter;
    @Autowired
    private SkillRepositoryCustom skillRepositoryCustom;


    @Override
    @Transactional
    public WorkerDTO add(WorkerDTO workerDTO) {
        WorkerEntity workerEntity = workerConverter.converterToEntity(workerDTO);
        workerEntity.setStatus(1);
        List<WorkerSkillEntity> workerSkillEntityList = new ArrayList<>();
        for(WorkerSkillDTO it: workerDTO.getWorkerSkillDTOList()){
            SkillEntity skillEntity = skillRepositoryCustom.findOneByName(it.getSkillDTO().getName());
            WorkerSkillEntity workerSkillEntity =workerSkillConverter.converterToEntity(it);
            workerSkillEntity.setSkillEntity(skillEntity);
            workerSkillEntity.setWorkerEntity(workerEntity);
            workerSkillEntityList.add(workerSkillEntity);
        }

        workerEntity.setWorkerSkillEntities(workerSkillEntityList);
        return workerConverter.convertToDTO(workerRepository.save(workerEntity));
    }
}
