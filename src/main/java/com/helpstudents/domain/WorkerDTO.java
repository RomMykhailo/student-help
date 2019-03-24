package com.helpstudents.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class WorkerDTO extends WorkerDTOForAll {
    @NotNull(message = "Field 'Email' can not be null")
    @Size(min=5, max=100, message = "Not valid length 'email'")
    private String email;
    @NotNull
    @Size
    private String password;
    @NotNull
    private String passwordConfirm;
    private String phoneNumber;

}
