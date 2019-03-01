package com.helpstudents.service;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.entity.WorkerEntity;

import java.util.List;

public interface WorkerService {

    void createWorker (WorkerDTO workerDTO);

    WorkerDTO getWorkerById (Long id);

    List<WorkerDTO> getAllWorker();
}
