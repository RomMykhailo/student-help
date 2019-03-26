package com.helpstudents;

import com.helpstudents.entity.AdminEntity;
import com.helpstudents.entity.RoleEntity;
import com.helpstudents.repository.AdminRepository;
import com.helpstudents.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableJpaRepositories()
public class StudentHelpApplication implements CommandLineRunner {
    public static void main(String[] args) {
         SpringApplication.run(StudentHelpApplication.class, args);
    }
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        if (roleRepository.count()==0){
            RoleEntity roleAdmin = new RoleEntity("ADMIN");
            roleRepository.save(roleAdmin);
            RoleEntity roleWorker = new RoleEntity("WORKER");
            roleRepository.save(roleWorker);
            RoleEntity roleCustomer = new RoleEntity("CUSTOMER");
            roleRepository.save(roleCustomer);
        }
        String email = "Romanskiy.miha@ukr.net";
        if(!adminRepository.existsByEmail(email)){
            AdminEntity adminEntity = new AdminEntity();
            adminEntity.setEmail(email);
            adminEntity.setPassword(passwordEncoder.encode("miha"));
            adminEntity.setFirstName("Mykhailo");
            adminEntity.setLastName("Romanskiy");
            adminEntity.setDeleted(false);
            adminEntity.setPhoneNumber("0978607298");
            RoleEntity roleEntity = roleRepository.findByRole("ADMIN").get();
            adminEntity.setRole(roleEntity);
            adminRepository.save(adminEntity);
        }

    }
}

