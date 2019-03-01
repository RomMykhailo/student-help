package com.helpstudents.service;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.entity.WorkerEntity;
import com.helpstudents.repository.WorkerRepository;
import com.helpstudents.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    @Autowired
    private ObjectMapperUtils objectMapperUtils;

    @Override
    public void createWorker(WorkerDTO workerDTO) {
        if (workerDTO.getPassword().equals(workerDTO.getPasswordConfirm())) {
            WorkerEntity workerEntity = objectMapperUtils.map(workerDTO, WorkerEntity.class);
//            workerEntity.setName(workerDTO.getName());
//            workerEntity.setEmail(workerDTO.getEmail());
//            workerEntity.setPassword(workerDTO.getPassword());
//            workerEntity.setDescription(workerDTO.getDescription());
            workerRepository.save(workerEntity);
        }else {
            System.out.println("Password not match");
        }
    }

    @Override
    public WorkerDTO getWorkerById(Long id) {
       WorkerEntity workerEntity = workerRepository.findById(id).get();
       WorkerDTO workerDTO = objectMapperUtils.map(workerEntity, WorkerDTO.class);
        return workerDTO;
    }

    @Override
    public List<WorkerDTO> getAllWorker() {
        List<WorkerEntity> workers = workerRepository.findAll();
        List<WorkerDTO> workerDTOS = objectMapperUtils.mapAll(workers, WorkerDTO.class);
//        workers.forEach(e->{WorkerDTO workerDTO = objectMapperUtils.map(e, WorkerDTO.class);
//            WorkerDTO workerDTO = new WorkerDTO();
//            workerDTO.setId(e.getId());
//            workerDTO.setName(e.getName());
//            workerDTO.setEmail(e.getEmail());
//            workerDTO.setDescription(e.getDescription());
//            workerDTOS.add(workerDTO);
//        });
        return workerDTOS;
    }
}
