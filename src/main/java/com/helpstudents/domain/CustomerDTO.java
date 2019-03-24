package com.helpstudents.domain;

import lombok.Data;
import javax.persistence.Column;

@Data
public class CustomerDTO extends CustomerDTOForAll {

    private String email;
    private String password;
    private String passwordConfirm;
    private String phoneNumber;

}
