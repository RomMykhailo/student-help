package com.helpstudents.entity;

import lombok.Data;

import javax.persistence.Column;

@Data
public class PeopleBaseEntity extends BaseEntity {

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    private String phoneNumber;
}
