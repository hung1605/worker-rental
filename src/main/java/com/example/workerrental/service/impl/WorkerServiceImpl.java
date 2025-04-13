package com.example.workerrental.service.impl;

import com.example.workerrental.builder.WorkerSearchBuilder;
import com.example.workerrental.converter.WorkerConverter;
import com.example.workerrental.converter.WorkerSearchBuilderConverter;
import com.example.workerrental.dto.WorkerDTO;
import com.example.workerrental.dto.WorkerSkillDTO;
import com.example.workerrental.repository.WorkerSkillRepository;
import com.example.workerrental.repository.custom.SkillRepositoryCustom;
import com.example.workerrental.repository.WorkerRepository;
import com.example.workerrental.repository.custom.WorkerRepositoryCustom;
import com.example.workerrental.repository.entity.Skill;
import com.example.workerrental.repository.entity.Worker;
import com.example.workerrental.repository.entity.WorkerSkill;
import com.example.workerrental.service.WorkerService;
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
        List<Worker> workerList = workerRepositoryCustom.searchWorker(workerSearchBuilder) ;
        List<WorkerDTO> result =new ArrayList<>();
        for(Worker it: workerList){
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
        List<Worker> workerList = workerRepository.findAll();
        for(Worker it: workerList){
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
        Worker worker = workerConverter.converterToEntity(workerDTO);
        worker.setStatus(1);
        List<WorkerSkill> workerSkillList = new ArrayList<>();

        for(WorkerSkill it: worker.getWorkerSkills()){
            Skill skill = skillRepositoryCustom.findOneByName(it.getSkill().getName());
            it.setSkill(skill);
            it.setWorkerEntity(worker);
            workerSkillList.add(it);
        }

        worker.setWorkerSkills(workerSkillList);
        return workerConverter.convertToDTO(workerRepository.save(worker));
    }

    @Override
    @Transactional
    public WorkerDTO updateWorker(Long id, WorkerDTO workerDTO) {
        Worker oldWorker = workerRepository.findById(id).get();
        oldWorker.setName(workerDTO.getName());
        oldWorker.setPhone(workerDTO.getPhone());
        oldWorker.setEmail(workerDTO.getEmail());
        oldWorker.setDayOfBirth(workerDTO.getDayOfBirth());
        oldWorker.setAddress(workerDTO.getAddress());
        oldWorker.setGender(workerDTO.getGender());
        oldWorker.setIdentityCard(workerDTO.getIdentityCard());

        // Cập nhật danh sách kỹ năng
        List<WorkerSkill> updatedworkerSkill = new ArrayList<>();
        for (WorkerSkillDTO workerSkillDTO : workerDTO.getWorkerSkills()) {
            Skill skill = skillRepositoryCustom.findOneByName(workerSkillDTO.getSkill().getName());

            // Tìm kỹ năng đã tồn tại của worker này
            WorkerSkill workerSkill = workerSkillRepository.findByWorkerAndSkill(oldWorker, skill);

            if(workerSkill == null){
                workerSkill = new WorkerSkill();
            }

            workerSkill.setYearsOfExperience(workerSkillDTO.getYearsOfExperience());
            workerSkill.setCertificate(workerSkillDTO.getCertificate());

            workerSkill.setSkill(skill);
            workerSkill.setWorkerEntity(oldWorker);

            updatedworkerSkill.add(workerSkill);
        }

        // Gán danh sách đã cập nhật vào oldWorkerEntity
        oldWorker.setWorkerSkills(updatedworkerSkill);

        // Lưu WorkerEntity (nó sẽ tự động cập nhật WorkerSkillEntity nếu dùng CascadeType.ALL)
        return workerConverter.convertToDTO(workerRepository.save(oldWorker));

    }

    @Override
    public void deleteWorker(Long id) {
        Worker worker = workerRepository.findById(id).get();
        worker.setStatus(0);
        workerRepository.save(worker);
    }
}
