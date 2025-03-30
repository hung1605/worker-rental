package com.example.workerrental.service.impl;


import com.example.workerrental.converter.SkillConverter;
import com.example.workerrental.converter.TaskConverter;
import com.example.workerrental.dto.TaskDTO;
import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.TaskRepository;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import com.example.workerrental.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private SkillRepository skillRepository;

    @Autowired
    private TaskConverter taskConverter;
    @Autowired
    private SkillConverter skillConverter;

    @Override
    @Transactional
    public TaskDTO getTaskById(Long id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskEntity taskEntity = optionalTask.get();
            return taskConverter.convertToDTO(taskEntity);  // Chuyển Entity sang DTO
        } else {
            throw new RuntimeException("Task not found with id: " + id); // Nếu không tìm thấy task, ném exception
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskEntities.stream()
                .map(taskEntity -> taskConverter.convertToDTO(taskEntity)) // Chuyển từ Entity sang DTO cho mỗi Task
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        // Kiểm tra nếu SkillEntity có sẵn trong DB, nếu không, ném exception
        Optional<SkillEntity> optionalSkill = skillRepository.findByName(taskDTO.getSkillEntity().getName());
        if (optionalSkill.isEmpty()) {
            throw new RuntimeException("Skill not found with name: " + taskDTO.getSkillEntity().getName());
        }

        // Chuyển từ DTO sang Entity và lưu vào DB
        TaskEntity newTaskEntity = taskConverter.converterToEntity(taskDTO);
        newTaskEntity.setSkillEntity(optionalSkill.get());

        // Gán skillEntity đã tìm thấy
        TaskEntity savedTaskEntity = taskRepository.save(newTaskEntity);
        return taskConverter.convertToDTO(savedTaskEntity); // Trả về TaskDTO của task đã lưu
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty()) {
            throw new RuntimeException("Task not found with id: " + id); // Nếu không tìm thấy task, ném exception
        }

        TaskEntity oldTaskEntity = optionalTask.get();
        // Kiểm tra nếu SkillEntity có sẵn trong DB, nếu không, ném exception
        Optional<SkillEntity> optionalSkill = skillRepository.findByName(taskDTO.getSkillEntity().getName());
        if (optionalSkill.isEmpty()) {
            throw new RuntimeException("Skill not found with name: " + taskDTO.getSkillEntity().getName());
        }

        // Cập nhật các trường trong Entity từ DTO
        oldTaskEntity = taskConverter.converterToEntity(taskDTO);
        oldTaskEntity.setId(id);
        oldTaskEntity.setSkillEntity(optionalSkill.get());// Gán lại skillEntity đã cập nhật

        TaskEntity updatedTaskEntity = taskRepository.save(oldTaskEntity);
        return taskConverter.convertToDTO(updatedTaskEntity); // Trả về TaskDTO của task đã cập nhật
    }

    @Override
    public Boolean deleteTask(Long id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id); // Xóa task theo id
            return true; // Trả về true nếu xóa thành công
        } else {
            return false; // Trả về false nếu không tìm thấy task với id
        }
    }
}
