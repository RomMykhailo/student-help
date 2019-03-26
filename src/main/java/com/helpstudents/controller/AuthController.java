package com.helpstudents.controller;

import com.helpstudents.domain.SigninWorkerDTO;
import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.service.AuthService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity registerWorker (@Valid @RequestBody WorkerDTO workerDTO) throws NotFoundException {
        authService.registerWorker(workerDTO);
        return new  ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("/signin")
    public ResponseEntity loginWorker (@Valid @RequestBody SigninWorkerDTO signinWorkerDTO){
        String token = authService.loginWorker(signinWorkerDTO);
        return  new ResponseEntity(token, HttpStatus.OK);
    }
}
