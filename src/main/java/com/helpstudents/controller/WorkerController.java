package com.helpstudents.controller;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import javax.validation.Valid;

@RestController
@RequestMapping("worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;


    @PostMapping("/add")
    public ResponseEntity<?> createWorker(@Valid @RequestBody WorkerDTO workerDTO){
        workerService.createWorker(workerDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<?> getWorkerById (@PathVariable Long id){
        WorkerDTO workerDTO = workerService.getWorkerById(id);
        return new ResponseEntity(workerDTO,HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/getAllForAdmin")
    public ResponseEntity<?> getAllWorkers (){
        return  new ResponseEntity<>(workerService.getAllWorker(),HttpStatus.OK);
    }
}
