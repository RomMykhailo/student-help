package com.helpstudents.service.impl;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.entity.WorkerEntity;
import com.helpstudents.exeptions.ExistsExceptions;
import com.helpstudents.repository.WorkerRepository;
import com.helpstudents.service.WorkerService;
import com.helpstudents.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            String password =workerEntity.getPassword();
//            workerEntity.setPassword(encoder.encode(password));
//            workerRepository.save(workerEntity);
        }else {
            System.out.println("Password not match");
        }
    }

    @Override
    public WorkerDTO getWorkerById(Long id) {
        boolean exists = workerRepository.existsById(id);
        if(!exists){
            throw new ExistsExceptions("Worker with id " + id + " not exists");
        }
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

    @Override
    public WorkerDTO findByNickName(String nickName) {
        WorkerDTO workerDTO = objectMapperUtils.map(workerRepository.findByNickName(nickName),WorkerDTO.class);
        return workerDTO;
    }
}
