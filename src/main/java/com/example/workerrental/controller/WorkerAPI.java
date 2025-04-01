package com.example.workerrental.controller;

import com.example.workerrental.model.WorkerDTO;
import com.example.workerrental.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class WorkerAPI {
    @Autowired
    private WorkerService workerService;

    @GetMapping("/api/worker/search")
    public ResponseEntity<List<WorkerDTO>> searchWorker(@RequestParam Map<String, String> field,
                                                        @RequestParam(name = "skillId", required = false) List<String> skillId){

        return ResponseEntity.ok(workerService.searchWorker(field, skillId));
    }

    @GetMapping("/api/workers")
    public ResponseEntity<List<WorkerDTO>> getWorkers(){
        return ResponseEntity.ok(workerService.getWorkers());
    }

    @GetMapping("/api/worker/{id}")
    public ResponseEntity<WorkerDTO> getWorker(@PathVariable("id") Long id){
        return ResponseEntity.ok(workerService.getWorker(id));
    }

    @PostMapping("/api/worker")
    public ResponseEntity<WorkerDTO> addWorker(@RequestBody WorkerDTO newWorker){
       return ResponseEntity.ok(workerService.addWorker(newWorker));
    }
    @PutMapping("/api/worker/{id}")
    public ResponseEntity<WorkerDTO> updateWorker(@PathVariable("id") Long id, @RequestBody WorkerDTO workerDTO){
        return ResponseEntity.ok(workerService.updateWorker(id, workerDTO));
    }

    @DeleteMapping("/api/worker/{id}")
    public ResponseEntity<Void> deleteWorker(@PathVariable("id") Long id){
        return ResponseEntity.noContent().build();
    }


}
