package com.helpstudents.domain;

import lombok.Data;

@Data
public class AdminDTO {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;
}
