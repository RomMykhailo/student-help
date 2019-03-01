package com.helpstudents.controller;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("workers")
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
        return new ResponseEntity<>(workerService.getWorkerById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllWorkers (){
        return  new ResponseEntity<>(workerService.getAllWorker(),HttpStatus.OK);
    }
}
