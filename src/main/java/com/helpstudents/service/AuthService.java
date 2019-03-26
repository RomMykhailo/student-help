package com.helpstudents.service;

import com.helpstudents.domain.SigninWorkerDTO;
import com.helpstudents.domain.WorkerDTO;
import javassist.NotFoundException;

public interface AuthService {
    void registerWorker (WorkerDTO workerDTO) throws NotFoundException;
    String loginWorker (SigninWorkerDTO workerDTO);
}
