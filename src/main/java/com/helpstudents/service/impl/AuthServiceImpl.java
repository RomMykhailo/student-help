package com.helpstudents.service.impl;

import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.entity.RoleEntity;
import com.helpstudents.entity.WorkerEntity;
import com.helpstudents.exeptions.ExistsExceptions;
import com.helpstudents.repository.RoleRepository;
import com.helpstudents.repository.WorkerRepository;
import com.helpstudents.service.AuthService;
import com.helpstudents.utils.ObjectMapperUtils;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private WorkerRepository workerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ObjectMapperUtils objectMapperUtils;
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void registerWorker(WorkerDTO workerDTO) throws NotFoundException {
        if(workerRepository.existsByEmail(workerDTO.getEmail())){
            throw new ExistsExceptions("Worker with email " + workerDTO.getEmail() + " already exists");
        }else if(!workerDTO.getPassword().equals(workerDTO.getPasswordConfirm())){
            throw new ExistsExceptions("Pasword and passwordConfirm not match");
        }
        String password = workerDTO.getPassword();
        workerDTO.setPassword(passwordEncoder.encode(password));
        WorkerEntity workerEntity = objectMapperUtils.map(workerDTO, WorkerEntity.class);
        RoleEntity roleEntity = roleRepository.findByRole("WORKER")
                .orElseThrow(()-> new NotFoundException("Role not found")
                );
        workerEntity.setRoles(Arrays.asList(roleEntity));
        workerRepository.save(workerEntity);
    }
}
