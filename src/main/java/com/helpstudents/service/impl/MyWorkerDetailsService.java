package com.helpstudents.service.impl;

import com.helpstudents.domain.MyWorkerPrincipal;
import com.helpstudents.domain.WorkerDTO;
import com.helpstudents.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyWorkerDetailsService implements UserDetailsService {

    @Autowired
    private WorkerService workerService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        WorkerDTO workerDTO = workerService.findByNickName(s);

        return new MyWorkerPrincipal(workerDTO);
    }
}
