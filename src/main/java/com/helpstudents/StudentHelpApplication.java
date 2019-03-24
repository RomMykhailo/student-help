package com.helpstudents;

import com.helpstudents.entity.RoleEntity;
import com.helpstudents.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class StudentHelpApplication {
    public static void main(String[] args) {
         SpringApplication.run(StudentHelpApplication.class, args);
    }
//    @Autowired
//    private RoleRepository roleRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        if (roleRepository.count()==0){
//            RoleEntity roleAdmin = new RoleEntity("ADMIN");
//            roleRepository.save(roleAdmin);
//            RoleEntity roleWorker = new RoleEntity("WORKER");
//            roleRepository.save(roleWorker);
//            RoleEntity roleCustomer = new RoleEntity("CUSTOMER");
//            roleRepository.save(roleCustomer);
//        }
//    }
}

