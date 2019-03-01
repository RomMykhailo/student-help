package com.helpstudents;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories()
public class StudentHelpApplication {

    public static void main(String[] args) {

        SpringApplication.run(StudentHelpApplication.class, args);
    }

}

