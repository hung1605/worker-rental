package com.example.workerrental.service.impl;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.converter.WorkerConverter;
import com.example.workerrental.converter.WorkerSearchBuilderConverter;
import com.example.workerrental.converter.WorkerSkillConverter;
import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.dto.WorkerSkillDTO;
import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.WorkerSkillRepository;
import com.example.workerrental.repository.custom.SkillRepositoryCustom;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.repository.custom.WorkerRepositoryCustom;
import com.example.workerrental.repository.custom.WorkerSkillRepositoryCustom;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.WorkerEntity;
import com.example.workerrental.repository.entity.WorkerSkillEntity;
import com.example.workerrental.service.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private WorkerRepositoryCustom workerRepositoryCustom;
    @Autowired
    private WorkerConverter workerConverter;

    @Autowired
    private SkillRepositoryCustom skillRepositoryCustom;
    @Autowired
    private WorkerSkillRepository workerSkillRepository;

    @Autowired
    private WorkerSearchBuilderConverter workerSearchBuilderConverter;

    @Override
    public List<WorkerDTO> searchWorker(Map<String, String> field, List<String> skillId) {
        WorkerSearchBuilder workerSearchBuilder = workerSearchBuilderConverter.toWorkerSearchBuilder(field, skillId);
        List<WorkerEntity> workerEntityList = workerRepositoryCustom.searchWorker(workerSearchBuilder) ;
        List<WorkerDTO> result =new ArrayList<>();
        for(WorkerEntity it:workerEntityList){
            WorkerDTO workerDTO = workerConverter.convertToDTO(it);
            result.add(workerDTO);
        }
        return result;
    }

    @Override
    public WorkerDTO getWorker(Long id) {
        return workerConverter.convertToDTO(workerRepository.findById(id).get());
    }

    @Override
    public List<WorkerDTO> getWorkers() {
        List<WorkerDTO> result = new ArrayList<>();
        List<WorkerEntity> workerEntityList = workerRepository.findAll();
        for(WorkerEntity it:workerEntityList){
            //Kiểm tra Worker còn tồn tại hay chưa
            if(it.getStatus()==1){
                result.add(workerConverter.convertToDTO(it));
            }
        }
        return result;
    }

    @Override
    @Transactional
    public WorkerDTO addWorker(WorkerDTO workerDTO) {
        WorkerEntity workerEntity = workerConverter.converterToEntity(workerDTO);
        workerEntity.setStatus(1);
        List<WorkerSkillEntity> workerSkillEntityList = new ArrayList<>();

        for(WorkerSkillEntity it: workerEntity.getWorkerSkills()){
            SkillEntity skillEntity = skillRepositoryCustom.findOneByName(it.getSkill().getName());
            it.setSkill(skillEntity);
            it.setWorkerEntity(workerEntity);
            workerSkillEntityList.add(it);
        }

        workerEntity.setWorkerSkills(workerSkillEntityList);
        return workerConverter.convertToDTO(workerRepository.save(workerEntity));
    }

    @Override
    @Transactional
    public WorkerDTO updateWorker(Long id, WorkerDTO workerDTO) {
        WorkerEntity oldWorkerEntity = workerRepository.findById(id).get();
        oldWorkerEntity.setName(workerDTO.getName());
        oldWorkerEntity.setPhone(workerDTO.getPhone());
        oldWorkerEntity.setEmail(workerDTO.getEmail());
        oldWorkerEntity.setDayOfBirth(workerDTO.getDayOfBirth());
        oldWorkerEntity.setAddress(workerDTO.getAddress());
        oldWorkerEntity.setGender(workerDTO.getGender());
        oldWorkerEntity.setIdentityCard(workerDTO.getIdentityCard());

        // Cập nhật danh sách kỹ năng
        List<WorkerSkillEntity> updatedworkerSkill = new ArrayList<>();
        for (WorkerSkillDTO workerSkillDTO : workerDTO.getWorkerSkills()) {
            SkillEntity skillEntity = skillRepositoryCustom.findOneByName(workerSkillDTO.getSkill().getName());

            // Tìm kỹ năng đã tồn tại của worker này
            WorkerSkillEntity workerSkillEntity = workerSkillRepository.findByWorkerEntityAndSkill(oldWorkerEntity, skillEntity);

            if(workerSkillEntity == null){
                workerSkillEntity = new WorkerSkillEntity();
            }

            workerSkillEntity.setYearsOfExperience(workerSkillDTO.getYearsOfExperience());
            workerSkillEntity.setCertificate(workerSkillDTO.getCertificate());

            workerSkillEntity.setSkill(skillEntity);
            workerSkillEntity.setWorkerEntity(oldWorkerEntity);

            updatedworkerSkill.add(workerSkillEntity);
        }

        // Gán danh sách đã cập nhật vào oldWorkerEntity
        oldWorkerEntity.setWorkerSkills(updatedworkerSkill);

        // Lưu WorkerEntity (nó sẽ tự động cập nhật WorkerSkillEntity nếu dùng CascadeType.ALL)
        return workerConverter.convertToDTO(workerRepository.save(oldWorkerEntity));

    }

    @Override
    public void deleteWorker(Long id) {
        WorkerEntity workerEntity = workerRepository.findById(id).get();
        workerEntity.setStatus(0);
        workerRepository.save(workerEntity);
    }
}
