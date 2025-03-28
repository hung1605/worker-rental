package com.example.workerrental.service.impl;


import com.example.workerrental.model.TaskDTO;
import com.example.workerrental.repository.SkillRepository;
import com.example.workerrental.repository.TaskRepository;
import com.example.workerrental.repository.entity.SkillEntity;
import com.example.workerrental.repository.entity.TaskEntity;
import com.example.workerrental.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public TaskDTO getTaskById(Integer id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskEntity taskEntity = optionalTask.get();
            return new TaskDTO(taskEntity);  // Chuyển Entity sang DTO
        } else {
            throw new RuntimeException("Task not found with id: " + id); // Nếu không tìm thấy task, ném exception
        }
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<TaskEntity> taskEntities = taskRepository.findAll();
        return taskEntities.stream()
                .map(TaskDTO::new) // Chuyển từ Entity sang DTO cho mỗi Task
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO createTask(TaskDTO taskDTO) {
        // Kiểm tra nếu SkillEntity có sẵn trong DB, nếu không, ném exception
        Optional<SkillEntity> optionalSkill = skillRepository.findById(taskDTO.getSkillEntity().getId());
        if (!optionalSkill.isPresent()) {
            throw new RuntimeException("Skill not found with id: " + taskDTO.getSkillEntity().getId());
        }

        // Chuyển từ DTO sang Entity và lưu vào DB
        TaskEntity taskEntity = new TaskEntity(taskDTO); // Sử dụng constructor của TaskEntity từ TaskDTO
        taskEntity.setSkillEntity(optionalSkill.get()); // Gán skillEntity đã tìm thấy

        TaskEntity savedTaskEntity = taskRepository.save(taskEntity);
        return new TaskDTO(savedTaskEntity); // Trả về TaskDTO của task đã lưu
    }

    @Override
    public TaskDTO updateTask(Integer id, TaskDTO taskDTO) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            TaskEntity taskEntity = optionalTask.get();

            // Cập nhật các trường trong Entity từ DTO
            taskEntity.setName(taskDTO.getName());
            taskEntity.setDescription(taskDTO.getDescription());
            taskEntity.setSalary(taskDTO.getSalary());
            taskEntity.setUnit(taskDTO.getUnit());
            taskEntity.setState(taskDTO.isState());

            // Kiểm tra nếu SkillEntity có sẵn trong DB, nếu không, ném exception
            Optional<SkillEntity> optionalSkill = skillRepository.findById(taskDTO.getSkillEntity().getId());
            if (!optionalSkill.isPresent()) {
                throw new RuntimeException("Skill not found with id: " + taskDTO.getSkillEntity().getId());
            }
            taskEntity.setSkillEntity(optionalSkill.get()); // Gán lại skillEntity đã cập nhật

            TaskEntity updatedTaskEntity = taskRepository.save(taskEntity);
            return new TaskDTO(updatedTaskEntity); // Trả về TaskDTO của task đã cập nhật
        } else {
            throw new RuntimeException("Task not found with id: " + id); // Nếu không tìm thấy task, ném exception
        }
    }

    @Override
    public Boolean deleteTask(Integer id) {
        Optional<TaskEntity> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            taskRepository.deleteById(id); // Xóa task theo id
            return true; // Trả về true nếu xóa thành công
        } else {
            return false; // Trả về false nếu không tìm thấy task với id
        }
    }
}
