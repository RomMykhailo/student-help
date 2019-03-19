package com.helpstudents.domain;

import lombok.Data;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Data
public class CustomerDTOForAll {
    private Long id;
    private String nickName;
    @Column(name = "description")
    private String description;
    private LocalDateTime dateCreate;
}
