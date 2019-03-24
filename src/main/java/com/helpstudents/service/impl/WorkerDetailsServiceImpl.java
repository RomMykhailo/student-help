package com.helpstudents.service.impl;

import com.helpstudents.entity.WorkerEntity;
import com.helpstudents.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private WorkerRepository workerRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        WorkerEntity workerEntity = workerRepository.findByEmail(email);
//                .orElseThrow(()-> new UsernameNotFoundException("Worker with email [" + email + "] not found"));
        return User.builder()
                    .username(workerEntity.getEmail())
                    .password(workerEntity.getPassword())
                    .authorities(getAuthorities(workerEntity))
                .build();
    }
    private List<SimpleGrantedAuthority> getAuthorities (WorkerEntity workerEntity){
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        workerEntity.getRoles().forEach(r-> {authorities.add(new SimpleGrantedAuthority("ROLE_"+ r.getRole()));});
        return authorities;
    }
}
