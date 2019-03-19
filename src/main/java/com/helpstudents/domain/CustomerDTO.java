package com.helpstudents.domain;

import lombok.Data;
import javax.persistence.Column;

@Data
public class CustomerDTO extends CustomerDTOForAll {

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
    private String passwordConfirm;
    private String phoneNumber;

}
