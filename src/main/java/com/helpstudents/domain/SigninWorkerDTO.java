package com.helpstudents.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninWorkerDTO {
    @NotNull(message = "Field 'Email' can not be null")
    @Size(min=5, max=30, message = "Not valid length 'email'")
    private String email;
    @NotNull
    @Size
    private String password;
}
